package B2;

/**
 * @author tiger
 */
enum PanelState {
    /**
     * 空闲状态
     */
    IDLE("IDLE", "空闲状态"),
    /**
     * 读取键入字符状态
     */
    READING_INPUT("READING_INPUT", "读取键入字符状态"),
    /**
     * 验证密码状态
     */
    VERIFYING_PASSWORD("VERIFYING_PASSWORD", "验证密码状态"),
    /**
     * 系统功能选择状态
     */
    FUNCTION_SELECT("FUNCTION_SELECT", "系统功能选择状态"),
    /**
     * 锁定控制面板状态
     */
    LOCKED("LOCKED", "锁定控制面板状态");

    private String name;
    private String value;

    PanelState(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PanelState{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}