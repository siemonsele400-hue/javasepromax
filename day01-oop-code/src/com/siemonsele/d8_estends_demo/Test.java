package com.siemonsele.d8_estends_demo;

public class Test {
    public static void main(String[] args) {

        //目标：搞清楚继承的好处
        //提升了代码的复用性
        Teacher t = new Teacher();
        t.setName("张三");
        t.setSkill("666");
        System.out.println(t.getName());
        System.out.println(t.getSkill());
    }
}


