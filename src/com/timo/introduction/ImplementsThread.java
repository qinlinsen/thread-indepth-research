package com.timo.introduction;

/**
 *用实现Runnable接口的方式来实现线程：
 * 核心方法是Thread(Runnable runnable)
 */

public class ImplementsThread implements Runnable {
    private String name;

    public ImplementsThread() {
    }

    public ImplementsThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            System.out.println(name+" running :"+ i);
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new ImplementsThread("A"));
        Thread threadB = new Thread(new ImplementsThread("B"));
        //启动A线程
        threadA.start();
        //启动B线程
        threadB.start();
    }
}
