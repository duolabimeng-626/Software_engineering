package B2;

import stateless.Action;

/**
 * 锁定超时→空闲：重置面板状态
 */
public class UnlockPanelAction implements Action {
    private final PanelGuard guard;

    public UnlockPanelAction(PanelGuard guard) {
        this.guard = guard;
    }

    @Override
    public void execute() {
        guard.resetWrongCount();
        guard.resetCharCount();
        System.out.println("锁定超时（>120秒），解锁面板，回到空闲状态");
    }
}