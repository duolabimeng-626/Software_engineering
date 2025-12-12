package B2;

/**
 * 控制面板状态转换事件
 */
public enum PanelEvent {
    /**
     * 户主开始输入密码
     */
    START_INPUT,
    /**
     * 输入一个字符
     */
    INPUT_CHAR,
    /**
     * 密码达到4位长度
     */
    PASSWORD_FULL,
    /**
     * 密码验证正确
     */
    PASSWORD_CORRECT,
    /**
     * 密码验证错误
     */
    PASSWORD_WRONG,
    /**
     * 锁定时间超过120秒
     */
    LOCK_TIMEOUT,
    /**
     * 进入功能选择完成
     */
    FUNCTION_DONE
}