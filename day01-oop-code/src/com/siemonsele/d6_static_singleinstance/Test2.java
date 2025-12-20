package com.siemonsele.d6_static_singleinstance;

public class Test2 {
    public static void main(String[] args) {
        //目标：理解单例模式的应用场景（懒汉式）
        B b = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b == b2);
    }
}
