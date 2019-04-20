package com.timo.introduction.classicproblem;

public class Info {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void set(String name,Integer age){
        this.age=age;
        this.name=name;
    }

    public void get(){
        System.out.println(Thread.currentThread().getName()+"===="+this.name+"====="+this.age);
    }
}
