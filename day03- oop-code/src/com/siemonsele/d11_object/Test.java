package com.siemonsele.d11_object;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握Object的常用方法。
        Student s1 = new Student("小昭", 21, 100);
        // 1、toString默认返回对象的所谓的地址形式其实是没有啥意义的，开发中输出对象更想看内容，因此toString是为了让子类重写
        System.out.println(s1.toString()); // 直接输出对象时，toString可以不写
        System.out.println(s1);

        System.out.println("------------------------------------------------------------");

        // 2、equals方法默认是比较两个对象的地址是否一样。
        // 比较两个对象的地址是否一样可以直接用“==”比较，完全没有必要用equals比较啊
        // 因此Object提供的equals的意义是为了让子类重写，以便自己制定比较规则（按照内容比较！）
        Student t1 = new Student("殷素素", 35, 98);
        Student t2 = new Student("殷素素", 35, 98);
        System.out.println(t1.equals(t2)); // true
        System.out.println(t1 == t2); // false

    }

}