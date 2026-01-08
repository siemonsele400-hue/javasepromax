package com.siemonsele.d13_interface;
 
public class Test {
    public static void main(String[] args) {
        // 目标： 接口其他注意事项（了解）
        Cat c = new Cat();
        c.test();

        C3 c3 = new C3();
        c3.run();
    }
}

//   4、一个类实现了多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
interface A3{
    default void run(){
        System.out.println("A3 - run");
    }
}
interface B3{
    default void run(){
        System.out.println("B3 - run");
    }
}
class C3 implements A3, B3{
    @Override
    public void run() {
        System.out.println("C3 - run");
        A3.super.run();
        B3.super.run();
    }
}


//  3、一个类继承了父类，又同时实现了接口，父类中和接口中有同名的默认方法，实现类会优先用父类的。
class Animal{
    public void run(){
        System.out.println("动物跑的贼溜~~");
    }
}
interface Go{
    default void run(){
        System.out.println("动物go的贼快~~");
    }
}
class Cat extends Animal implements Go {
    public void test(){
        run(); // 亲爹的
        Go.super.run(); // 干爹的！
    }
}


// 1、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承。
/*interface A1{
    String run();
}
interface B1{
    void run();
}
interface C1 extends A1, B1{
}*/

// 2、一个类实现多个接口，如果多个接口中存在方法签名冲突，则此时不支持多实现。
/*interface A2{
    String run();
}
interface B2{
    void run();
}
class C1 implements A2, B2{
}*/


