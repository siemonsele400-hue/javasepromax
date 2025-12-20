package com.siemonsele.d14_estends_field;

public class Test {
    public  static void main(String[] args) {
        //目标：继承后，子类访问成员的特点：就近原则
        zi z = new zi();
        z.showName();
    }
}

class zi extends  fu{
    String name = "子类名称";

    public void showName(){
        String name = "局部名称";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}

class fu{
    String name = "父类名称";
}