package com.siemonsele.d1_static_field;

public class Test2 {
    public static void main(String[] args) {
        //目标：搞清楚static修饰成员变量的应用场景
        new  User();
        new  User();
        new  User();
        System.out.println("创建了几个对象：" + User.number);
    }
}
