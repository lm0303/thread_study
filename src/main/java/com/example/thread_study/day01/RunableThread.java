package com.example.thread_study.day01;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class RunableThread implements Runnable{
    /**
     *
     */
    @Override
    public void run() {
        System.out.println("实现Runable接口实现线程");
    }
}
