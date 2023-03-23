package com.example.thread_study.day01;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class ExtendThread extends Thread{
    /**
     *
     */
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }
}
