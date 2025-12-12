package B2;

import stateless.FuncBoolean;

/**
 * 控制面板状态转换条件
 */
public class PanelGuard {
    // 密码长度（固定4位）
    private static final int PASSWORD_LENGTH = 4;
    // 当前输入的字符数
    private int inputCharCount;
    // 密码错误次数
    private int wrongCount;
    // 锁定时长（秒）
    private int lockTime;

    public PanelGuard() {
        this.inputCharCount = 0;
        this.wrongCount = 0;
        this.lockTime = 0;
    }

    // 更新输入字符数
    public void incrementCharCount() {
        this.inputCharCount++;
    }

    // 重置输入字符数
    public void resetCharCount() {
        this.inputCharCount = 0;
    }

    // 递增错误次数
    public void incrementWrongCount() {
        this.wrongCount++;
    }

    // 重置错误次数
    public void resetWrongCount() {
        this.wrongCount = 0;
    }

    // 更新锁定时长
    public void setLockTime(int lockTime) {
        this.lockTime = lockTime;
    }

    // ========== Guard条件 ==========
    /**
     * 输入字符数未达4位
     */
    public FuncBoolean isCharCountLessThan4() {
        return () -> inputCharCount < PASSWORD_LENGTH;
    }

    /**
     * 输入字符数达到4位
     */
    public FuncBoolean isCharCountEqual4() {
        return () -> inputCharCount == PASSWORD_LENGTH;
    }

    /**
     * 错误次数小于3次
     */
    public FuncBoolean isWrongCountLessThan3() {
        return () -> wrongCount < 3;
    }

    /**
     * 错误次数等于3次
     */
    public FuncBoolean isWrongCountEqual3() {
        return () -> wrongCount == 3;
    }

    /**
     * 锁定时间超过120秒
     */
    public FuncBoolean isLockTimeOver120() {
        return () -> lockTime > 120;
    }
}