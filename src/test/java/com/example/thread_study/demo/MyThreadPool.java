package com.example.thread_study.demo;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author : limeng
 * @date : 2023/1/10
 * @description :
 */
public class MyThreadPool extends Thread {
    private int coreThreadSize;

    private int maxThreadSize;

    private int queueSize;

    private boolean isShutdown;

    private long keepAliveTime;

    private TimeUnit timeUnit;

    private BlockingQueue runableQueue;

    private int activityCount;

    private ThreadFactory threadFactory;

    private final static Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    public MyThreadPool(int coreThreadSize, int maxThreadSize, ThreadFactory threadFactory, BlockingQueue workerQueue, int keepAliveTime, TimeUnit timeUnit) {
        this.coreThreadSize = coreThreadSize;
        this.maxThreadSize = maxThreadSize;
        this.threadFactory = threadFactory;
        this.runableQueue = workerQueue;
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
    }

    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()) {
            synchronized (this) {
                if (isShutdown) {
                    break;
                }
                if (runableQueue.size() > 0) {
                    for (int i = runableQueue.size(); i < maxThreadSize; i++) {
                        newThread();
                    }
                }
                if (runableQueue.size() == 0 && activityCount > coreThreadSize) {
                    for (int i = coreThreadSize; i < activityCount; i++) {
                        removeThread();
                    }
                }
            }

        }
    }

    public void submit(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("the pool is shutdown...");
        }

        this.runableQueue.offer(runnable);
    }

    public void newThread() {
        Worker worker = new Worker(runableQueue);
        Thread thread = threadFactory.newThread(worker);
        ThreadTask threadTask = new ThreadTask(worker, thread);
        threadQueue.offer(threadTask);
        this.activityCount++;
        thread.start();

    }

    public void removeThread() {
        this.activityCount--;
        ThreadTask threadTask = threadQueue.remove();
        threadTask.getWorker().stop();
    }

    public void init() {
        this.start();
        for (int i = 0; i < coreThreadSize; i++) {
            newThread();
        }
    }

    public void shutDown() {
        synchronized (this) {
            if (isShutdown) {
                return;
            }
            isShutdown = true;
            for (ThreadTask threadTask : threadQueue) {
                threadTask.getWorker().stop();
                threadTask.getThread().interrupt();
            }
        }
    }
}
