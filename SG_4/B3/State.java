package B3;

/**
 * @author tiger
 */
enum ExtractState {
    /**
     * 普通文本状态
     */
    NORMAL_TEXT("NORMAL_TEXT", "普通文本状态"),
    /**
     * 字符串内状态
     */
    IN_STRING("IN_STRING", "字符串内状态"),
    /**
     * 转义状态
     */
    ESCAPE("ESCAPE", "转义状态");

    private String name;
    private String value;

    ExtractState(String name, String value) {
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
        return "ExtractState{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}