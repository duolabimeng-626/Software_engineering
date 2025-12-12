package B1;

import stateless.Action;

/**
 * 任意状态 → 休眠：自动断开电源
 */
public class EnterSleepAction implements Action {
    @Override
    public void execute() {
        System.out.println("进入休眠：当前23点，自动断开电源");
    }
}