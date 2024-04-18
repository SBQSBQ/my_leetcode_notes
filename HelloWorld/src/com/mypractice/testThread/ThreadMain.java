package com.mypractice.testThread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {
    public static void main(String[] args) {
    }

    @Test
    public void cacheThreadPoolTest() {
        // 创建可缓存的无界线程池，可以指定线程工厂，也可以不指定线程工厂
        ExecutorService executorService = Executors.newCachedThreadPool(new testThreadPoolFactory("cachedThread"));
        for (int i = 0; i < 10; i++) {
//            executorService.submit(this::task);

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("cachedThreadPool");
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    private void task() {
        System.out.println("cachedThreadPool");
        System.out.println(Thread.currentThread().getName());
    }

}
