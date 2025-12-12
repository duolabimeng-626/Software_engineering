package B2;

import stateless.Action;

/**
 * 读取输入中：累计字符数
 */
public class IncrementCharAction implements Action {
    private final PanelGuard guard;

    public IncrementCharAction(PanelGuard guard) {
        this.guard = guard;
    }

    @Override
    public void execute() {
        guard.incrementCharCount();
        System.out.println("输入1个字符，当前长度：" + guard.getInputCharCount());
    }
}