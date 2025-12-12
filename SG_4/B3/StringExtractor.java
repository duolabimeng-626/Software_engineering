package B3;

import stateless.StateMachine;

/**
 * 字符串提取器核心状态机
 */
public class StringExtractor {
    private final StateMachine<ExtractState, ExtractEvent> stateMachine;
    private final ExtractContext context;

    public StringExtractor() {
        this.context = new ExtractContext();
        this.stateMachine = new StateMachine<>(ExtractState.NORMAL_TEXT);
        configureStateTransitions();
    }

    private void configureStateTransitions() {
        // ========== 普通文本状态（NORMAL_TEXT） ==========
        stateMachine.configure(ExtractState.NORMAL_TEXT)
                // 事件：读取到" → 字符串内状态（初始化缓冲区）
                .permit(ExtractEvent.READ_QUOTE, ExtractState.IN_STRING,
                        new EnterStringAction(context))
                // 事件：读取到普通字符/反斜杠 → 保持普通文本（忽略）
                .ignore(ExtractEvent.READ_NORMAL_CHAR)
                .ignore(ExtractEvent.READ_BACKSLASH)
                // 事件：文件结束 → 结束（提示）
                .permit(ExtractEvent.FILE_END, ExtractState.NORMAL_TEXT,
                        new FileEndAction(context));

        // ========== 字符串内状态（IN_STRING） ==========
        stateMachine.configure(ExtractState.IN_STRING)
                // 事件：读取到" → 普通文本状态（保存结果）
                .permit(ExtractEvent.READ_QUOTE, ExtractState.NORMAL_TEXT,
                        new ExitStringAction(context))
                // 事件：读取到\ → 转义状态
                .permit(ExtractEvent.READ_BACKSLASH, ExtractState.ESCAPE)
                // 事件：读取到普通字符 → 保持字符串内（添加字符）
                .permit(ExtractEvent.READ_NORMAL_CHAR, ExtractState.IN_STRING,
                        new AddNormalCharAction(context))
                // 事件：文件结束 → 结束（提示未闭合）
                .permit(ExtractEvent.FILE_END, ExtractState.IN_STRING,
                        new FileEndAction(context));

        // ========== 转义状态（ESCAPE） ==========
        stateMachine.configure(ExtractState.ESCAPE)
                // 事件：读取任意字符 → 字符串内状态（添加转义后的字符）
                .permit(ExtractEvent.READ_NORMAL_CHAR, ExtractState.IN_STRING,
                        new AddNormalCharAction(context))
                .permit(ExtractEvent.READ_QUOTE, ExtractState.IN_STRING,
                        new AddNormalCharAction(context))
                .permit(ExtractEvent.READ_BACKSLASH, ExtractState.IN_STRING,
                        new AddNormalCharAction(context));
    }

    // ========== 外部API：处理单个字符 ==========
    public void processChar(char c) {
        context.setCurrentChar(c);
        if (c == '"') {
            stateMachine.fire(ExtractEvent.READ_QUOTE);
        } else if (c == '\\') {
            stateMachine.fire(ExtractEvent.READ_BACKSLASH);
        } else {
            stateMachine.fire(ExtractEvent.READ_NORMAL_CHAR);
        }
    }

    // 处理文件结束
    public void processFileEnd() {
        stateMachine.fire(ExtractEvent.FILE_END);
    }

    // 获取提取结果
    public String[] getExtractedStrings() {
        return context.getResultStrings().toArray(new String[0]);
    }

    // 获取当前状态
    public ExtractState getCurrentState() {
        return stateMachine.getState();
    }
}