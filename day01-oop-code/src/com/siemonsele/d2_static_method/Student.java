package com.siemonsele.d2_static_method;

public class Student {
    double score;

    //静态方法：有static修饰，属于类持有，建议用类名访问，也可以用对象访问
    public static void printHelloworld(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello World");
        }
    }

    //实例方法：对象的方法，必须用对象触发访问
    public void proitPass(){
        System.out.println(score >= 60 ? "通过" : "挂科");
    }
}
