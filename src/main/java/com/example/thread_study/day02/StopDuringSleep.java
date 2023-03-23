package com.example.thread_study.day02;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 100) {
                    System.out.println(num);
                    num++;
                    Thread.sleep(100);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
