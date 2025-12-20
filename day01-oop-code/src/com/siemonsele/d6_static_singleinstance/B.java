package com.siemonsele.d6_static_singleinstance;

public class B {
    //2,定义一个静态变量用于记住类的一个唯一对象
    private static B b;
     //1.私有构造器
    private B(){}
     //3.
    public static B getInstance(){
        //第一次来拿读一下的时候，是需要创建对象的，后面不创建的
        if(b == null){
            //第一次拿需要创建对象
            b = new B();
        }
        return b;
    }
}
