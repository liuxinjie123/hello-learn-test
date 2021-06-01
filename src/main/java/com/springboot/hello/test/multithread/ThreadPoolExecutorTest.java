package com.springboot.hello.test.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static class TempThread extends Thread {
        public TempThread(){};

        public TempThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            // 打印正在执行的缓存线程信息
            try {
                System.out.println(Thread.currentThread().getName() + "正在被执行");
                // sleep一秒保证3个任务在分别在3个线程上执行
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建数组型缓冲等待队列
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(2);
        // ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 30, TimeUnit.SECONDS, bq, new ThreadPoolExecutor.CallerRunsPolicy());

        // 创建3个任务
        Thread t1 = new TempThread("t1");
        Thread t2 = new TempThread("t2");
        Thread t3 = new TempThread("t3");
        Thread t4 = new TempThread("t4");
        Thread t5 = new TempThread("t5");
        Thread t6 = new TempThread("t6");
        Thread t7 = new TempThread("t7");
        Thread t8 = new TempThread("t8");
        Thread t9 = new TempThread("t9");

        // 3个任务在分别在3个线程上执行
        tpe.execute(t1);
        Thread.sleep(1000);
        tpe.execute(t2);
        Thread.sleep(1000);
        tpe.execute(t3);
        Thread.sleep(1000);
        tpe.execute(t4);
        Thread.sleep(1000);
        tpe.execute(t5);
        Thread.sleep(1000);
        tpe.execute(t6);
        Thread.sleep(1000);
        tpe.execute(t7);
        Thread.sleep(1000);
        tpe.execute(t8);
        Thread.sleep(1000);
        tpe.execute(t9);
        Thread.sleep(1000);

        // 关闭自定义线程池
        tpe.shutdown();
    }



}
