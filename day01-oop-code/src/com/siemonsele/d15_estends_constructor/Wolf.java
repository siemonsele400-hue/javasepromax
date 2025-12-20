package com.siemonsele.d15_estends_constructor;

public class Wolf extends  Animal{
    public Wolf() {
//        super();//写不写都有，调用杜磊无参数构造器的
        System.out.println("Wolf类的无参构造器");
    }

    public  Wolf(String  name){
//        super();//写不写都有，调用杜磊无参数构造器的
        System.out.println("Wolf类的有参构造器");
    }

}
