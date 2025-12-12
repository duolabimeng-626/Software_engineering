package B1;

/**
 * 触发状态转换的事件
 */
public enum TankEvent {
    /**
     * 温度检测事件（触发温度相关状态转换）
     */
    TEMPERATURE_CHECK,
    /**
     * 时间触发事件（7点/23点触发）
     */
    TIME_TRIGGER,
    /**
     * 烧坏事件（触发烧坏状态）
     */
    BURN_OUT;
}