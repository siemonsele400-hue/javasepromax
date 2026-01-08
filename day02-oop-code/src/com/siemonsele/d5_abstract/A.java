package com.siemonsele.d5_abstract;

//抽象类：使用了abstract修饰的
public abstract class A {
    private String name;
    private int age;

    public A() {
    }

    //抽象方法：abstract修饰，只能有方法签名，不能有方法体
    public abstract void go();
    public abstract void run();

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
