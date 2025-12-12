package B3;

import stateless.Action;

/**
 * 普通文本→字符串内：初始化缓冲区
 */
public class EnterStringAction implements Action {
    private final ExtractContext context;

    public EnterStringAction(ExtractContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.resetBuffer();
        System.out.println("进入字符串内状态，开始收集字符串");
    }
}