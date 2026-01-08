package com.siemonsele.d9_interface2;

public class Test {
    //目标：理解接口的好处
    //1.接口弥补了类单继承的不足：接口让一个对象拥有更多角色更多能力
    People s1 = new Student();
    Driver d = new Student();
    Doctor d2 = new Student();

    //2.面向接口编程是软件开发中目前很流行的开发模式，能更灵活的视线解耦合
    Driver d3 = new Teacher();
    Driver d4 = new Student();
}
