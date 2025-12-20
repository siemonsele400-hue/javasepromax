package com.siemonsele.d6_static_singleinstance;

public class A {

    //2.定义一个静态变量用于记住类的一个唯一对象
    private static A a = new A();
    //1.把类的构造器私有化处理
    private A(){
    }

    //3.提供一个静态方法返回这个唯一的对象
    public static A getInstance(){
        return a;
    }
}
