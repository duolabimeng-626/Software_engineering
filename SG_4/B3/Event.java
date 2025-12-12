package B3;

/**
 * 字符串提取状态转换事件
 */
public enum ExtractEvent {
    /**
     * 读取到双引号（"）
     */
    READ_QUOTE,
    /**
     * 读取到反斜杠（\）
     */
    READ_BACKSLASH,
    /**
     * 读取到普通字符
     */
    READ_NORMAL_CHAR,
    /**
     * 文件读取完成
     */
    FILE_END
}