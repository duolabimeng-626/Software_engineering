package B1;

import stateless.Action;

/**
 * 待机 → 烧水：打开继电器电源
 */
public class StartBoilingAction implements Action {
    @Override
    public void execute() {
        System.out.println("开始烧水：打开继电器电源");
    }
}