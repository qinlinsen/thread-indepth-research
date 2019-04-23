package com.timo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondtionDemo {
    private static class Mywork{
        private volatile boolean flag=true;//是否等待
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();
        public void sub(){
            try{
                lock.lock();
                if (!flag){
                    try {
                        //线程进入等待状态
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("sub run ----------------");
                flag=false;
                condition.signal();
            }finally {
                lock.unlock();//这里一定要释放锁
            }
        }
        public void main(){
            try{
                lock.lock();
                if(flag){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("main run");
                flag=true;
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        Mywork mywork=new Mywork();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    mywork.sub();
                }
            }
        },"sub-thread").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    mywork.main();
                }
            }
        },"main-thread").start();
    }
}

