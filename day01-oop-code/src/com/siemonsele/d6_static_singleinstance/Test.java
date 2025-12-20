package com.siemonsele.d6_static_singleinstance;

public class Test {
    public static void main(String[] args) {
        //目标：理解单例模式的应用场景（饿汉式）
        A a = A.getInstance();
        A a1 = A.getInstance();
        System.out.println(a);
        System.out.println(a1);
    }
}
