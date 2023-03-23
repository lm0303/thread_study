package com.example.thread_study.demo;

import lombok.Getter;

/**
 * @author : limeng
 * @date : 2023/1/10
 * @description :
 */
public class ThreadTask{

    @Getter
    private Worker worker;

    @Getter
    private Thread thread;

    public ThreadTask(Worker worker, Thread thread) {
        this.worker = worker;
        this.thread = thread;
    }
}
