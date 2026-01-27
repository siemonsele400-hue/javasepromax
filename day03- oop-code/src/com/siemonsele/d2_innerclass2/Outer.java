package com.siemonsele.d2_innerclass2;
//外部类
public class Outer {
    public static String schoolName = "zzuit";
    public static void inAddr(){
        System.out.println("我们在zzuit");
    }
    private double height;

    private double weight;
    //静态内部类：有static修饰，属于外部类本身的
    public static class Inner{
        //类有的成员他都有
        private String name;
        private int age;

        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        //成员内部类访问外部类的成员特点
        public void show(){
            //1.静态部类中，是否可以直接访问外部类的静态成员？  可以
            System.out.println(schoolName);
            inAddr();
            //2，静态内部类中是否可以直接访问外部类的实例成员？  不可以
            System.out.println(name);
            //System.out.println(weight);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

