package com.example.thread_study.threadPool;

public interface ThreadFactory {
    //创建一个新的线程
    Thread createThread(Runnable runnable);
}
