package com.siemonsele.d7_abstract_demo2;

public class Test {
    public static void main(String[] args) {
        //目标：完成学生和老师写作文的功能（模版方法改进）
        //写作文的步骤和架构是统一的：
//          1.第一步是一样的：都是写标题 《我的爸爸》
//          2.第一段：是一样的
//          3，第二段：都是写正文，但内容随意发挥
//          4.第三段：都是一样的
        People p1 = new Teacher();
        p1.write();
        People p2 = new Student();
        p2.write();
    }
}
