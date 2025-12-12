package B3;

import stateless.Action;

/**
 * 字符串内/转义→添加字符到缓冲区
 */
public class AddNormalCharAction implements Action {
    private final ExtractContext context;

    public AddNormalCharAction(ExtractContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.getStringBuffer().append(context.getCurrentChar());
        System.out.println("添加字符到缓冲区：" + context.getCurrentChar());
    }
}