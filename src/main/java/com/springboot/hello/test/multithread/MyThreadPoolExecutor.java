package com.springboot.hello.test.multithread;

import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行工具类
 */
public class MyThreadPoolExecutor {

    public static ThreadPoolExecutor newThreadPool() {
        //获取系统处理器个数，作为线程池数量
//        int nThreads = Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadPoolTaskExecutor();

        //Common Thread Pool
       return new ThreadPoolExecutor(3, 6,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(100), namedThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = newThreadPool();
        executor.allowCoreThreadTimeOut(true);
        LocalDateTime start = LocalDateTime.now();
        for (int i=0; i<1000; i++) {
//            Thread.sleep(50);
            int finalI = i;
            if (executor.getQueue().size() > 10 && executor.getQueue().size() < 50) {
                executor.setCorePoolSize(5);
                executor.setMaximumPoolSize(8);
            } else if (executor.getQueue().size() > 50) {
                executor.setCorePoolSize(8);
                int available = Runtime.getRuntime().availableProcessors();
                System.out.println("-------------------------- available = " + available);
                executor.setMaximumPoolSize(200);
            } else if (executor.getQueue().size() < 10) {
                executor.setCorePoolSize(3);
                executor.setMaximumPoolSize(6);
            }
            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    int temp = finalI;
                    System.out.println(" temp : " + temp + " start");
                    Thread.sleep(2000);
                    System.out.println(" temp : " + temp + " ----------------------- end");
                }
            });
            System.out.println(" -------------------- core pool size: " + executor.getCorePoolSize());
            System.out.println(" -------------------- max pool size: " + executor.getMaximumPoolSize());
        }

        LocalDateTime end = LocalDateTime.now();
        System.out.println(" start: " + start);
        System.out.println(" end: " + end);
//        executor.shutdown();


    }

}
