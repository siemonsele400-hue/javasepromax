package com.siemonsele.d3_polymorphism;

public class Test {
    public static void main(String[] args) {
       //目标：搞清楚多态下的类型转换问题
        Animal a = new Dog();
        a.cry();
        //强制类型转换：可以解决多态下不能直接调用子类独有方法的问题
        Dog d = (Dog)a;
        go(a);
        
        Cat c = new Cat();
        go(c);
     /*   强制类型转换的注意事项1：只有继承或者实现关秀的两个类就可以强制转换
        编译阶段不会报错（写代码），但是运行时可能出现强制类型转换异常
        Cat c = (Cat)a;  编译时不报错，运行时报错

        因此java建议强制转换前。先判断对象的真实类型，再进行强制转换

        if (a instanceof Dog){
            Dog d2 = (Dog)a;
            d2.lookDoor();
        }else if (a instanceof Cat){
            Cat c2 = (Cat)a;
            c2.eat();
        }
      */
    }

    //2.多态下，父类类型作为方法的形参，可以接受一切子类对象，方法恆便利
    public static void go(Animal a){
        System.out.println("开始，，，");
        a.cry(); //对象回调
        if (a instanceof Dog){
            Dog d2 = (Dog)a;
            d2.lookDoor();
        }else if (a instanceof Cat){
            Cat c2 = (Cat)a;
            c2.eat();
        }
        System.out.println("结束，，，");
    }
}
