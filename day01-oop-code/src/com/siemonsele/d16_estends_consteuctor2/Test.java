package com.siemonsele.d16_estends_consteuctor2;

public class Test {
    public static void main(String[] args) {
       // 目标：子类为啥要调用父类构造器：初始化继承自父类部分的数据。
        Teacher t1 = new Teacher();
        t1.setName("播妞");
        t1.setAge(35);
        t1.setSkill("Java,嵌入式");
        System.out.println(t1.getName());
        System.out.println(t1.getAge());
        System.out.println(t1.getSkill());

        Teacher t2 = new Teacher("黑马dlei" , 34, "Java，吹牛逼！");
        System.out.println(t2.getName());
        System.out.println(t2.getAge());
        System.out.println(t2.getSkill());
    }
}
