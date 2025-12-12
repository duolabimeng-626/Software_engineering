package B1;

/**
 * 恒温水箱状态枚举
 * @author tiger
 * @date 2025-11-25
 */
enum TankState {
    /**
     * 待机状态
     */
    STANDBY("STANDBY", "待机状态"),
    /**
     * 烧水状态
     */
    BOILING("BOILING", "烧水状态"),
    /**
     * 休眠状态
     */
    SLEEP("SLEEP", "休眠状态"),
    /**
     * 烧坏状态（最终状态）
     */
    BROKEN("BROKEN", "烧坏状态");

    private String name;
    private String value;

    TankState(String name, String value) {
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
        return "TankState{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}