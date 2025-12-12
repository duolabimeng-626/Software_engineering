package B3;

import stateless.Action;

/**
 * 文件结束：提示状态
 */
public class FileEndAction implements Action {
    private final ExtractContext context;

    public FileEndAction(ExtractContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        if (!context.getStringBuffer().isEmpty()) {
            System.out.println("文件结束提示：该字符串未闭合");
        }
        System.out.println("文件读取完成，共提取字符串" + context.getResultStrings().size() + "个");
    }
}