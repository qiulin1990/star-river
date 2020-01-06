package com.cloudwalk.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class ThreadPoolTool {
    /**
     * {@link ThreadPoolExecutor.DiscardPolicy}
     * {@link ThreadPoolExecutor.CallerRunsPolicy}
     * {@link ThreadPoolExecutor.AbortPolicy}
     */
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 80,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(500), new ThreadPoolExecutor.CallerRunsPolicy());

    public static int execute(Runnable runnable) {
        executorService.submit(runnable);
        return executorService.getQueue().size();
    }
}