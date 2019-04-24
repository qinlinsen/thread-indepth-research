package com.timo;

import java.security.PolicySpi;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        for(int i=0;i<3;i++){
           Runnable runnable= new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程："+Thread.currentThread().getName()+" 即将达到集合地点1" +

                                "，当前已有 "+(cyclicBarrier.getNumberWaiting()+1));
                        cyclicBarrier.await();
                        Exchanger exchanger;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
                        System.out.println("都到达了");
        }
    }
}
