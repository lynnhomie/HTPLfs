package org.simpledfs.core.command;

import com.beust.jcommander.Parameter;
/*小型java框架，用来解析命令行参数（该方式允许我们从cmd命令行窗口运行Java的应用程序，而不是单击操作系统中的应用程序图标）*/
public class Command {

    @Parameter(names={"--file", "-f"}, help = true, required =true, description = "file path")
    private String file;
/*文件路径参数，接受形式为String*/
    @Parameter(names = "--help", help = true)
    private boolean help;
/*帮助，接收类型为boolean*/
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }
}
