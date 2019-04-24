package com.timo;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunication {
    private volatile boolean flag=true;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void qin(){
        //acquire a lock
        try {
            lock.lock();
            if (flag) {
                condition.await();
            }
            for(int i=0;i<2;i++){
                System.out.println("qin");
            }
            condition.signal();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //release a lock
            lock.unlock();
        }

    }
    public void lin(){
        //acquire a lock
        try {
            lock.lock();
            if (!flag) {
                condition.await();
            }
            for(int i=0;i<2;i++){
                System.out.println("lin");
            }
            condition.signal();
            flag=false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //release a lock
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ThreadCommunication threadCommunication=new ThreadCommunication();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    threadCommunication.qin();
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    threadCommunication.lin();
                }
            }
        }).start();
    }
}
