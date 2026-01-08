package com.siemonsele.d12_interface_jdk8;

public interface A {
    //1.默认方法（普通方法，实例方法）：必须用default修饰
    //默认会用public修饰
    //必须又接口的实现类的对象来调用
    default void run() {
        go();
        System.out.println("泡的贼快~~");
    }

    //2.私有方法（私有的实例方法）（jdk9开始才有的）
    //只能当前接口内部的默认方法或者私有方法来调用
    private  void go() {
        System.out.println("开始跑~~");
    }

    //3.静态方法
    //默认会用public修饰
    //接口的静态方法必须用接口名本身调用
    static void inAddr(){
        System.out.println("郎新博要跑步~~");
    }
}
