package com.timo.introduction.classicproblem;

public class Consumer implements Runnable {
    private Info info;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<15;i++) {
            this.info.get();
        }
    }
}
