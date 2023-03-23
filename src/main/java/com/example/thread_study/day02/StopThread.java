package com.example.thread_study.day02;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class StopThread implements Runnable{

    /**
     *
     */
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count=" + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
