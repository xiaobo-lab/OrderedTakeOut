package com.r948.utilities;

public class ThreadUtil {

    /**
     * 创建一个线程去执行任务
     *
     * @param runnable 任务
     */
    public static void invoke(Runnable runnable) {
        new Thread() {
            @Override
            public void run() {
                synchronized (ThreadUtil.class) {
                    runnable.run();
                }
            }
        }.start();
    }
}
