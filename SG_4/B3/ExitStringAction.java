package B3;

import stateless.Action;

/**
 * 字符串内→普通文本：保存结果
 */
public class ExitStringAction implements Action {
    private final ExtractContext context;

    public ExitStringAction(ExtractContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        String extracted = context.getStringBuffer().toString();
        context.getResultStrings().add(extracted);
        System.out.println("提取字符串：" + extracted);
        context.resetBuffer();
    }
}