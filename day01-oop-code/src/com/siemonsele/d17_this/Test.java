package com.siemonsele.d17_this;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握this调用兄弟构造器的作用
        // 1、创建对象封装数据。
        Student s1 = new Student("孙悟空", 500, "三星洞");
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getSchoolName());

        // 需求：只要不给学校，学校默认是黑马的。
        // 注意事项：
        //  this(...) super(...) 不能同时出现，且必须在构造器的第一行！
        Student s2 = new Student("蜘蛛精", 900);
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getSchoolName());
    }
}
