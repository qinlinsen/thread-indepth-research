package com.timo.introduction.different;

public class UnsharedResource extends Thread {
    private String name;

    public UnsharedResource(String name) {
        this.name = name;
    }

    private int ticket=7;
    @Override
    public void run() {
        for (int i=0;i<20;i++){
           if(ticket>0){
               System.out.println(Thread.currentThread().getName()+" 正在卖票："+ticket--);
           }
        }
    }

    public static void main(String[] args) {
        UnsharedResource unsharedResource = new UnsharedResource("1号窗口");
        UnsharedResource unsharedResource2 = new UnsharedResource("2号窗口");
        UnsharedResource unsharedResource3 = new UnsharedResource("3号窗口");
        unsharedResource.start();
        unsharedResource2.start();
        unsharedResource3.start();
    }
}
