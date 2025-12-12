package B1;

import stateless.Action;

/**
 * 休眠 → 待机：唤醒恒温流程
 */
public class WakeToStandbyAction implements Action {
    @Override
    public void execute() {
        System.out.println("唤醒待机：当前7点，恢复恒温烧水流程");
    }
}