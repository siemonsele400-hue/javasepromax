package com.siemonsele.d2_polymorphism;

public class Test {
    public static void main(String[] args) {
       //目标：搞清楚使用多态的好处
        //1.多态下右边对象是解耦合的
        Animal a = new Dog();
        a.cry();

        Animal a1 = new Cat();
        go(a1);
        Animal a2 = new Dog();
        go(a2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        //多态下存在的一个问题：不能直接调用子类独有的功能
//        a.lookDoor();//报错
    }

    //2.多态下，父类类型作为方法的形参，可以接受一切子类对象，方法恆便利
    public static void go(Animal a){
        System.out.println("开始，，，");
        a.cry(); //对象回调
        /*
        多态下存在的一个问题：不能直接调用子类独有的功能
        a.lppkDoor();
        a.cat();
*/
        System.out.println("结束，，，");
    }
}
