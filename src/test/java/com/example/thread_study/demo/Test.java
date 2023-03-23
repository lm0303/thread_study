package com.example.thread_study.demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : limeng
 * @date : 2023/1/10
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10, 20, Executors.defaultThreadFactory(), new ArrayBlockingQueue(10), 1, TimeUnit.MINUTES);
        for (int i = 0; i < 20; i++) {
            myThreadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is running and done.");
            });
        }
    }
}
