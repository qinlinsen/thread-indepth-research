package com.timo.introduction.classicproblem;

public class Client {
    public static void main(String[] args) {
        Info info = new Info();
        info.setName("qin");
        info.setAge(28);
        Producer producer = new Producer();
        producer.setInfo(info);
        Consumer consumer = new Consumer();
        consumer.setInfo(info);
        new Thread(producer,"生产者").start();
        new Thread(consumer,"消费者").start();
    }
}
