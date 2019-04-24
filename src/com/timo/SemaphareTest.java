package com.timo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphareTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //可以维护当前访问的线程的自身个数
       final Semaphore semaphore = new Semaphore(3,true);
        for(int i=0;i<10;i++){
          Runnable runnable=  new Runnable(){

                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程："+Thread.currentThread().getName()+
                            " 进入,当前已有"+(3-semaphore.availablePermits()));

                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程："+Thread.currentThread().getName()+" 即将离开");
                    semaphore.release();

                    System.out.println("线程："+Thread.currentThread().getName()+
                            " 进入,当前已有"+(3-semaphore.availablePermits()));
                }
            };
          executorService.execute(runnable);
        }
          executorService.shutdown();
    }
}
