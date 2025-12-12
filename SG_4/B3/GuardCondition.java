package B3;

import stateless.FuncBoolean;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串提取的上下文（包含Guard条件+数据存储）
 */
public class ExtractContext {
    // 当前读取的字符
    private char currentChar;
    // 字符串缓冲区（临时存储当前字符串）
    private StringBuilder stringBuffer;
    // 提取结果集
    private List<String> resultStrings;

    public ExtractContext() {
        this.stringBuffer = new StringBuilder();
        this.resultStrings = new ArrayList<>();
    }

    // 设置当前读取的字符
    public void setCurrentChar(char currentChar) {
        this.currentChar = currentChar;
    }

    // 获取结果集
    public List<String> getResultStrings() {
        return resultStrings;
    }

    // 重置字符串缓冲区
    public void resetBuffer() {
        stringBuffer.setLength(0);
    }

    // ========== Guard条件（此处逻辑简单，直接通过事件触发，条件内置） ==========
    // 注：因事件已区分字符类型，Guard主要用于状态合法性判断

    /**
     * 当前处于普通文本状态
     */
    public FuncBoolean isInNormalText() {
        return () -> true; // 事件触发时已处于对应状态
    }
}