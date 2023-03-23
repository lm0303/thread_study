package com.example.thread_study.demo;

import java.util.concurrent.BlockingQueue;

/**
 * @author : limeng
 * @date : 2023/1/10
 * @description : 工作线程
 */
public class Worker implements Runnable {

    // 工作队列
    private BlockingQueue queue;

    private volatile boolean isRun;

    public Worker(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (isRun && !Thread.currentThread().isInterrupted()) {
            Runnable task = null;
            try {
                task = (Runnable) queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            task.run();
        }
    }

    public void stop() {
        isRun = false;
    }
}
