package B2;

import stateless.Action;

/**
 * 错误3次→锁定：启动面板锁定
 */
public class LockPanelAction implements Action {
    @Override
    public void execute() {
        System.out.println("密码错误3次，锁定控制面板");
    }
}