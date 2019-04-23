package com.timo.timer.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程内部共享数据，线程间数据独立,这个就是ThreadLocal类实现的一个雏形
 */
public class ThreadScopeShareData {
    public static Map<Thread,Integer> threadData=new HashMap<>();
    static class A {
        public void get(){
            Integer data = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() + " get data :" + data);
        }
    }
    static class B {
        public void get(){
            Integer data = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() + " get data :" + data);
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<6;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" has put data: "+data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

}
