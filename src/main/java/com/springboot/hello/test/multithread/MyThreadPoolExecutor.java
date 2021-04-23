package com.springboot.hello.test.multithread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行工具类
 */
public class MyThreadPoolExecutor {

//    public static ThreadPoolExecutor newThreadPool() {
//        //获取系统处理器个数，作为线程池数量
//        int nThreads = Runtime.getRuntime().availableProcessors();
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("my-thread-pool-%d").build();
//
//        //Common Thread Pool
//       return new ThreadPoolExecutor(1, 1,
//                60000L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
//    }

}
