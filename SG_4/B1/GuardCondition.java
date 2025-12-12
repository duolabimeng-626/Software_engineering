package B1;

import stateless.FuncBoolean;

/**
 * 状态转换的条件判断
 */
public class TankGuard {
    // 温度（单位：°C）
    private int temperature;
    // 是否有水
    private boolean hasWater;
    // 当前时间（24小时制，仅关注小时）
    private int currentHour;

    public TankGuard() {
        this.temperature = 25; // 默认常温
        this.hasWater = true;  // 默认有水
        this.currentHour = 12; // 默认中午
    }

    // setter 供外部更新状态
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public void setCurrentHour(int currentHour) {
        this.currentHour = currentHour;
    }

    // ========== Guard 条件（返回 FuncBoolean 供状态机使用） ==========
    /**
     * 温度 < 20°C
     */
    public FuncBoolean isTemperatureBelow20() {
        return () -> temperature < 20;
    }

    /**
     * 温度 >= 100°C
     */
    public FuncBoolean isTemperatureReach100() {
        return () -> temperature >= 100;
    }

    /**
     * 水箱有水
     */
    public FuncBoolean hasWater() {
        return () -> hasWater;
    }

    /**
     * 当前时间是 23 点（晚上11点）
     */
    public FuncBoolean isTime23() {
        return () -> currentHour == 23;
    }

    /**
     * 当前时间是 7 点（早上7点）
     */
    public FuncBoolean isTime7() {
        return () -> currentHour == 7;
    }
}