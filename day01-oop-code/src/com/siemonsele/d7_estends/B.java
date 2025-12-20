package com.siemonsele.d7_estends;

public class B extends A{
    private int k;
    public void print3(){
        //继承特点:（专业，权威）：子类中只能继承父亲非私有的成员
        System.out.println("B.print3()");
        print();

//      System.out.println(j);
//      print2();
   }

}
