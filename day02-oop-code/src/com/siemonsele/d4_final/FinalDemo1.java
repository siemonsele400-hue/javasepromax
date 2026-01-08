package com.siemonsele.d4_final;

public class FinalDemo1 {
    // 5、final修饰静态成员变量：称为常量。
    // static final修饰的成员变量今后叫做常量。值只有一个，而且不能被改变
    // 常量的单词建议全部大写，多个单词用下划线链接
    public static final String SCHOOL_NAME = "郎新博";
    public static final String SCHOOL_NAME2;
    static {
        SCHOOL_NAME2 = "lxb";
        // SCHOOL_NAME2 = "深圳黑马2";// 报错，第二次赋值！
    }

    // 6、final修饰实例成员变量（没有意义）
    private final String name = "胡姑娘"; // 没有啥意义！！

    public static void main(String[] args) {
        // 目标：掌握final关键字的作用。
        // 3、final修饰变量：有且仅能赋值一次。
        // java的变量有几种？
        /**
         *  局部变量：方法内，形参，for循环变量，构造器中的变量都是局部变量。
         *  成员变量
         *      静态成员变量
         *      实例成员变量
         */
        // 4、final修饰局部变量
        final int a = 12;
        // a = 15; // 报错，第二次赋值！
        final double r = 3.14;
        buy(0.7);

        // SCHOOL_NAME = "黑马2";  // 报错，第二次赋值！
    }

    public static void buy(final double z){
        // z = 0.1; // 报错，第二次赋值！
    }
}

// 1、final修饰类，类不能被继承
//final class A{}
//class B extends A{}

// 2、final修饰方法，方法不能被重写。
/*
class C{
    public final void run(){
    }
}

class D extends C{
    @Override
    public void run() {
    }
}*/
