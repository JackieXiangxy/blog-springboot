package com.jackie.bloghandle.ffmpeg.test;

import com.jackie.bloghandle.ffmpeg.CommandManager;
import com.jackie.bloghandle.ffmpeg.CommandManagerImpl;
import com.jackie.bloghandle.ffmpeg.commandbuidler.CommandBuidlerFactory;
import com.jackie.bloghandle.ffmpeg.data.CommandTasker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试
 *
 * @author jackie
 * @version 1.0
 * @since jdk1.8
 */
public class Test {
    /**
     * 命令组装器测试
     *
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        Map<String, String> map = new HashMap<>();
        map.put("appName", "test123");
        map.put("input", "rtsp://192.168.1.130:8554/00000012081310000001/0");
        map.put("output", "rtmp://127.0.0.1/live/Test123");
        map.put("codec", "h264");
        map.put("fmt", "flv");
        map.put("-c:v", "copy");
        map.put("-c:a", "copy");
        map.put("fps", "30");
        map.put("rs", "1920*1080");
        map.put("twoPart", "2");
        // 执行任务，id就是appName，如果执行失败返回为null
        String id = manager.start(map);//开始执行转码程序
        System.out.println("当前任务-------->" + id + "执行成功！！！");
        System.out.println("当前任务-------->" + id + "执行成功！！！");
        // 通过id查询
        CommandTasker info = manager.query(id);
        System.out.println(info);
        System.out.println("当前任务" + id + "的信息为：" + info);
        // 查询全部
        Collection<CommandTasker> infoList = manager.queryAll();
        System.out.println("当前执行的全部任务------->" + infoList);
        Thread.sleep(30000);
        // 停止id对应的任务
        manager.stop(id);
    }

    /**
     * 默认方式，rtsp->rtmp转流单个命令测试
     *
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        // -rtsp_transport tcp
        //测试多个任何同时执行和停止情况
        //默认方式发布任务
        manager.start("tomcat", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat");

        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
    }

    /**
     * 完整ffmpeg路径测试
     *
     * @throws InterruptedException
     */
    public static void test4() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        // -rtsp_transport tcp
        //测试多个任何同时执行和停止情况
        //默认方式发布任务
        manager.start("tomcat", "D:/TestWorkspaces/FFmpegCommandHandler/src/cc/eguid/FFmpegCommandManager/ffmpeg/ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat", true);

        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
    }

    /**
     * rtsp-rtmp转流多任务测试
     *
     * @throws InterruptedException
     */
    public static void test3() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        // -rtsp_transport tcp
        //测试多个任何同时执行和停止情况
        //false表示使用配置文件中的ffmpeg路径，true表示本条命令已经包含ffmpeg所在的完整路径
        manager.start("tomcat", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat", false);
        manager.start("tomcat1", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat1", false);
        manager.start("tomcat2", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat2", false);
        manager.start("tomcat3", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat3", false);
        manager.start("tomcat4", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat4", false);
        manager.start("tomcat5", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat5", false);
        manager.start("tomcat6", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat6", false);
        manager.start("tomcat7", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat7", false);
        manager.start("tomcat8", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat8", false);
        manager.start("tomcat9", "ffmpeg -i rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov -vcodec copy -acodec copy -f flv -y rtmp://106.14.182.20:1935/rtmp/tomcat9", false);

        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
    }

    /**
     * 测试流式命令行构建器
     *
     * @throws InterruptedException
     */
    public static void testStreamCommandAssmbly() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        manager.start("test1", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test1"));
        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
    }

    /**
     * 测试任务中断自动重启任务
     *
     * @throws InterruptedException
     */
    public static void testBroken() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        manager.start("test1", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test1"));
        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
        manager.destory();
    }

    /**
     * 批量测试任务中断自动重启任务
     *
     * @throws InterruptedException
     */
    public static void testBrokenMuti() throws InterruptedException {
        CommandManager manager = new CommandManagerImpl();
        manager.start("test1", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test1"));
        manager.start("test2", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test2"));
        manager.start("test3", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test3"));
        manager.start("test4", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
                .add("-rtsp_transport", "tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test4"));
        manager.start("test5", CommandBuidlerFactory.createBuidler()
                .add("ffmpeg").add("-i", "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov")
//				.add("-rtsp_transport","tcp")
                .add("-vcodec", "copy")
                .add("-acodec", "copy")
                .add("-f", "flv")
                .add("-y").add("rtmp://106.14.182.20:1935/rtmp/test5"));
        Thread.sleep(30000);
        // 停止全部任务
        manager.stopAll();
        manager.destory();
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
//		test2();
//		test3();
//		test4();
//		testStreamCommandAssmbly();
//		testBroken();
//		testBrokenMuti();
    }
}
