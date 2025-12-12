package B2;

import stateless.Action;

/**
 * 验证密码错误：累计错误次数
 */
public class PasswordWrongAction implements Action {
    private final PanelGuard guard;

    public PasswordWrongAction(PanelGuard guard) {
        this.guard = guard;
    }

    @Override
    public void execute() {
        guard.incrementWrongCount();
        System.out.println("密码错误，当前错误次数：" + guard.getWrongCount());
    }
}