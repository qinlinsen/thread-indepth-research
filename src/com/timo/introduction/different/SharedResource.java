package com.timo.introduction.different;

/**
 * 共享资源的原因是：共用一个target
 */

public class SharedResource implements Runnable {
    private static SharedResource target;
    private String name;

    public SharedResource(String name) {
        this.name = name;
    }

    private int ticket=3;
    @Override
    public void run() {
        for (int i=0;i<20;i++){
           if(ticket>0){
               System.out.println(Thread.currentThread().getName()+" 正在卖票："+ticket--);
           }
        }
    }

    public static void main(String[] args) {
        target = new SharedResource("");
        Thread threadA = new Thread(target, "1号窗口");
        Thread threadB = new Thread(target, "2号窗口");
        Thread threadC= new Thread(target, "3号窗口");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
