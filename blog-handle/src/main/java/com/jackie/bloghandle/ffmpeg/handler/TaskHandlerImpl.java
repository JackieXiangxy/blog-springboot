package com.jackie.bloghandle.ffmpeg.handler;

import java.io.IOException;

import com.jackie.bloghandle.ffmpeg.CommandManager;
import com.jackie.bloghandle.ffmpeg.data.CommandTasker;
import com.jackie.bloghandle.ffmpeg.util.ExecUtil;

/**
 * 任务处理实现
 *
 * @author jackie
 * @version 1.0
 * @since jdk1.8
 */
public class TaskHandlerImpl implements TaskHandler {

    private OutHandlerMethod ohm = null;

    public TaskHandlerImpl(OutHandlerMethod ohm) {
        this.ohm = ohm;
    }

    public void setOhm(OutHandlerMethod ohm) {
        this.ohm = ohm;
    }

    /**
     * 执行ffmpeg命令
     *
     * @param id      应用名称
     * @param command ffmpeg命令
     * @return
     */
    @Override
    public CommandTasker process(String id, String command) {
        CommandTasker tasker = null;
        try {
            tasker = ExecUtil.createTasker(id, command, ohm);

            if (CommandManager.config.isDebug()) System.out.println(id + " 执行命令行：" + command);

            return tasker;
        } catch (IOException e) {
            //运行失败，停止任务
            ExecUtil.stop(tasker);

            if (CommandManager.config.isDebug())
                System.err.println(id + " 执行命令失败！进程和输出线程已停止");

            // 出现异常说明开启失败，返回null
            return null;
        }
    }

    @Override
    public boolean stop(Process process) {
        return ExecUtil.stop(process);
    }

    @Override
    public boolean stop(Thread outHandler) {
        return ExecUtil.stop(outHandler);
    }

    @Override
    public boolean stop(Process process, Thread thread) {
        boolean ret = false;
        ret = stop(thread);
        ret = stop(process);
        return ret;
    }
}
