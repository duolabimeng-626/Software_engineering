package B2;

import stateless.StateMachine;

/**
 * 控制面板核心状态机
 */
public class ControlPanel {
    private final StateMachine<PanelState, PanelEvent> stateMachine;
    private final PanelGuard guard;

    public ControlPanel() {
        this.guard = new PanelGuard();
        this.stateMachine = new StateMachine<>(PanelState.IDLE);
        configureStateTransitions();
    }

    private void configureStateTransitions() {
        // ========== 空闲状态（IDLE） ==========
        stateMachine.configure(PanelState.IDLE)
                // 事件：开始输入 → 读取输入状态（执行初始化）
                .permit(PanelEvent.START_INPUT, PanelState.READING_INPUT,
                        new StartReadingAction(guard));

        // ========== 读取键入字符状态（READING_INPUT） ==========
        stateMachine.configure(PanelState.READING_INPUT)
                // 事件：输入字符 → 字符数不足4位 → 保持读取状态（累计字符）
                .permitIf(PanelEvent.INPUT_CHAR, PanelState.READING_INPUT,
                        guard.isCharCountLessThan4(),
                        new IncrementCharAction(guard))
                // 事件：输入字符 → 字符数达到4位 → 验证密码状态
                .permitIf(PanelEvent.INPUT_CHAR, PanelState.VERIFYING_PASSWORD,
                        guard.isCharCountEqual4());

        // ========== 验证密码状态（VERIFYING_PASSWORD） ==========
        stateMachine.configure(PanelState.VERIFYING_PASSWORD)
                // 事件：密码正确 → 功能选择状态
                .permit(PanelEvent.PASSWORD_CORRECT, PanelState.FUNCTION_SELECT)
                // 事件：密码错误 → 错误次数<3 → 读取输入状态（重置字符数）
                .permitIf(PanelEvent.PASSWORD_WRONG, PanelState.READING_INPUT,
                        guard.isWrongCountLessThan3(),
                        new PasswordWrongAction(guard))
                // 事件：密码错误 → 错误次数=3 → 锁定状态
                .permitIf(PanelEvent.PASSWORD_WRONG, PanelState.LOCKED,
                        guard.isWrongCountEqual3(),
                        new LockPanelAction(guard));

        // ========== 锁定状态（LOCKED） ==========
        stateMachine.configure(PanelState.LOCKED)
                // 事件：锁定超时 → 空闲状态（重置状态）
                .permitIf(PanelEvent.LOCK_TIMEOUT, PanelState.IDLE,
                        guard.isLockTimeOver120(),
                        new UnlockPanelAction(guard));

        // ========== 功能选择状态（FUNCTION_SELECT） ==========
        stateMachine.configure(PanelState.FUNCTION_SELECT)
                // 事件：功能完成 → 最终状态
                .permit(PanelEvent.FUNCTION_DONE, PanelState.FUNCTION_SELECT);
    }

    // ========== 外部API ==========
    public void fireEvent(PanelEvent event) {
        stateMachine.fire(event);
    }

    public void setLockTime(int lockTime) {
        guard.setLockTime(lockTime);
    }

    public PanelState getCurrentState() {
        return stateMachine.getState();
    }

    public int getInputCharCount() {
        return guard.getInputCharCount();
    }

    public int getWrongCount() {
        return guard.getWrongCount();
    }
}