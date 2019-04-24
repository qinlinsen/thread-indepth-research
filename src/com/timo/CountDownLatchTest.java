package com.timo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
       final CountDownLatch order = new CountDownLatch(1);
       final CountDownLatch answer = new CountDownLatch(3);
        for(int i=0;i<3;i++){
           Runnable command= new Runnable(){
                @Override
                public void run() {
                    try {
                        order.await();
                        System.out.println("count"+order.getCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(command);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            order.countDown();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        executorService.shutdown();
    }
}
