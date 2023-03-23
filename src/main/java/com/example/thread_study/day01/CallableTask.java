package com.example.thread_study.day01;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : limeng
 * @date : 2022/12/1
 * @description :
 */
public class CallableTask implements Callable<Integer> {
    /**
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 提交任务，并用Future返回结果
        Future<Integer> future = service.submit(new CallableTask());
    }

}
