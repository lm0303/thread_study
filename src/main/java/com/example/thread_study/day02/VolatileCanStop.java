package com.example.thread_study.day02;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class VolatileCanStop implements Runnable {

    private volatile boolean cancled = false;

    /**
     *
     */
    @Override
    public void run() {
        int num = 0;
        try {
            while (!cancled && num <= 10000) {
                if (num % 10 == 0) {
                    System.out.println(num + "是10的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop volatileCanStop = new VolatileCanStop();
        Thread thread = new Thread(volatileCanStop);
        thread.start();
        Thread.sleep(3000);
        volatileCanStop.cancled = true;
    }
}
