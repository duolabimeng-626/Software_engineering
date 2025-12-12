package B1;

import stateless.Action;

/**
 * 烧水 → 待机：断开电源
 */
public class StopBoilingAction implements Action {
    @Override
    public void execute() {
        System.out.println("停止烧水：温度达到100°C，断开电源");
    }
}