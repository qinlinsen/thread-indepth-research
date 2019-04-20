package com.timo.introduction;

/**
 * 用继承Thread类的方式实现线程
 * 其实本质上和实现Runnable接口是一样的，
 * 因为：Thread类就是实现了Runnable接口的
 */

public class ExtendsThread extends Thread {
    private String name;

    public ExtendsThread() {
    }

    public ExtendsThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0;i<15;i++){
            System.out.println(name+" running :"+ i);
        }
    }

    public static void main(String[] args) {
        ExtendsThread threadA = new ExtendsThread("A");
        ExtendsThread threadB = new ExtendsThread("B");
        System.out.println(threadA.isAlive());
        //启动A线程
        threadA.start();
        //判断线程是否启动的方法
        System.out.println(threadA.isAlive());
        //启动B线程
        threadB.start();
    }
}
