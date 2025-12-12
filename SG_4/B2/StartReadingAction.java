package B2;

import stateless.Action;

/**
 * 空闲→读取输入：初始化输入状态
 */
public class StartReadingAction implements Action {
    private final PanelGuard guard;

    public StartReadingAction(PanelGuard guard) {
        this.guard = guard;
    }

    @Override
    public void execute() {
        guard.resetCharCount();
        System.out.println("进入读取输入状态，开始接收密码输入");
    }
}