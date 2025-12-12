package B1;

import stateless.StateMachine;

/**
 * 恒温水箱核心状态机
 */
public class ThermostatTank {
    // 状态机核心对象
    private final StateMachine<TankState, TankEvent> stateMachine;
    // 条件判断器
    private final TankGuard guard;

    /**
     * 初始化：默认进入待机状态
     */
    public ThermostatTank() {
        this.guard = new TankGuard();
        // 初始状态：待机
        this.stateMachine = new StateMachine<>(TankState.STANDBY);
        // 配置状态转换规则
        configureStateTransitions();
    }

    /**
     * 配置所有状态转换规则（严格对应状态图）
     */
    private void configureStateTransitions() {
        // ========== 待机状态（STANDBY） ==========
        stateMachine.configure(TankState.STANDBY)
                // 规则1：温度检测 → 温度<20°C 且 有水 → 烧水状态（执行启动烧水）
                .permitIf(TankEvent.TEMPERATURE_CHECK, TankState.BOILING,
                        guard.isTemperatureBelow20().and(guard.hasWater()),
                        new StartBoilingAction())
                // 规则2：温度检测 → 温度<20°C 但 无水 → 保持待机（忽略事件）
                .ignoreIf(TankEvent.TEMPERATURE_CHECK,
                        guard.isTemperatureBelow20().and(guard.hasWater().negate()))
                // 规则3：时间触发 → 23点 → 休眠状态（执行进入休眠）
                .permitIf(TankEvent.TIME_TRIGGER, TankState.SLEEP,
                        guard.isTime23(),
                        new EnterSleepAction());

        // ========== 烧水状态（BOILING） ==========
        stateMachine.configure(TankState.BOILING)
                // 规则1：温度检测 → 温度≥100°C → 待机状态（执行停止烧水）
                .permit(TankEvent.TEMPERATURE_CHECK, TankState.STANDBY,
                        new StopBoilingAction())
                // 规则2：时间触发 → 23点 → 休眠状态（执行进入休眠）
                .permitIf(TankEvent.TIME_TRIGGER, TankState.SLEEP,
                        guard.isTime23(),
                        new EnterSleepAction())
                // 规则3：烧坏事件 → 烧坏状态（最终状态）
                .permit(TankEvent.BURN_OUT, TankState.BROKEN);

        // ========== 休眠状态（SLEEP） ==========
        stateMachine.configure(TankState.SLEEP)
                // 规则1：时间触发 → 7点 → 待机状态（执行唤醒待机）
                .permitIf(TankEvent.TIME_TRIGGER, TankState.STANDBY,
                        guard.isTime7(),
                        new WakeToStandbyAction())
                // 规则2：休眠状态忽略温度检测事件
                .ignore(TankEvent.TEMPERATURE_CHECK);

        // ========== 烧坏状态（BROKEN） ==========
        stateMachine.configure(TankState.BROKEN)
                // 规则：忽略所有事件（等待维修）
                .ignore(TankEvent.TEMPERATURE_CHECK)
                .ignore(TankEvent.TIME_TRIGGER);
    }

    // ========== 外部暴露方法（仿照 Heater.java 的 API 风格） ==========
    /**
     * 触发事件（如温度检测、时间触发）
     */
    public void fire(TankEvent event) {
        stateMachine.fire(event);
    }

    /**
     * 更新温度
     */
    public void setTemperature(int temperature) {
        guard.setTemperature(temperature);
    }

    /**
     * 设置水量状态（true=有水，false=无水）
     */
    public void setHasWater(boolean hasWater) {
        guard.setHasWater(hasWater);
    }

    /**
     * 更新当前时间（仅关注小时，24小时制）
     */
    public void setCurrentHour(int currentHour) {
        guard.setCurrentHour(currentHour);
    }

    /**
     * 获取当前状态
     */
    public TankState getCurrentState() {
        return stateMachine.getState();
    }
}