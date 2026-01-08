package com.siemonsele.d11_interface_extends;

public class Test {
    public static void main(String[] args) {
        //目标：接口的多继承
        //类与类是单继承的：一个类只能直接继承一个父类
        //类与接口是多实现的：一个类可以同时实现多个接口
        //接口和接口是多继承的：一个接口可以同时继承多个接口（课程重点）
    }
}
//接口的多继承可以让实现类只实现一个接口就相当于实现了多个接口
class D implements A {
    @Override
    public void a(){}

    @Override
    public void b(){}

    @Override
    public void c(){}
}

//一个接口可以同时继承多个接口
interface A extends B,C {
    void a();
}
interface B {
    void b();
}
interface C {
    void c();
}