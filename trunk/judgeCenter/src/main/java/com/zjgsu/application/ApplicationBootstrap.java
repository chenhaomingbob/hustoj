package com.zjgsu.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 应用程序入口.
 * @author chm 神魔法
 * @date 2019/5/31 17:42
 */
public class ApplicationBootstrap {
    public static void main(String[] args) {
        Logger.info("Starting JudgeCenter...");
        ApplicationBootstrap app = new ApplicationBootstrap();
        app.getApplicationContext();
        app.setUpShutdownHook();
        Logger.info("JudgeCenter started OK!");
    }

    /**
     * 加载应用程序配置.
     */
    private void getApplicationContext() {
        applicationContext = new
                ClassPathXmlApplicationContext("application-context.xml");
    }

    /**
     * 设置ShutdownHook.
     * 用于完成程序正常退出前的准备工作.
     */
    private void setUpShutdownHook() {
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Logger.info("JudgeCenter is shutting down...");
                    mainThread.join();
                } catch (InterruptedException ex) {
                    Logger.catching(ex);
                }
            }
        });
    }

    /**
     * 应用程序配置.
     */
    private static ApplicationContext applicationContext;
    /**
     * 日志记录器.
     */
    private static final Logger Logger = LogManager.getLogger(ApplicationBootstrap.class);
}
