package com.timo.introduction.classicproblem;

public class Producer implements Runnable{
    public Info info;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        boolean flag=false;
        for (int i=0;i<15;i++) {
            if (flag){
                this.info.set("qin",28);
                flag=false;
            }else{
                this.info.set("ran", 25);
                flag=true;
            }
        }
    }
}
