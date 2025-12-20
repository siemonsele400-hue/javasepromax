package com.siemonsele.d9_estends_modifier;

public class Fu {
     //1.private私有的，只能在本类中访问
    private void privateMethod(){
        System.out.println("privateMethod()");
    }
     //2.缺省：只能在本类，同一个包下的其他类中访问
    void method(){
        System.out.println("method()");
    }
    //3.protected：只能本类，同一个包下的其他类，子孙类中访问
    protected void protectedMethod(){
        System.out.println("protectedMethod()");
    }
    //4.public 公开权限：任何类中都可以访问
     public void publicMethod(){
        System.out.println("publicMethod()");
    }

    public static void main(String[] args) {
    Fu f = new Fu();
    f.privateMethod();
    f.method();
    f.protectedMethod();
    f.publicMethod();
    }
}
