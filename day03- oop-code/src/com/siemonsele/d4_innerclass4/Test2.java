package com.siemonsele.d4_innerclass4;

public class Test2 {
    public static void main(String[] args) {
        //目标：匿名内部类的使用场景：通过作为一个对象参数传输给方法使用
        Swimming s1 = new Swimming(){
            @Override
            public void swim(){
                System.out.println("学生游泳贼溜~~~");
            }
        };
        go(s1);

        go(new Swimming(){
            @Override
            public void swim(){
                System.out.println("老师游泳贼慢~~~");
            }
        });
    }
    public static void go(Swimming s){
        System.out.println("开始~~");
        s.swim();
        System.out.println("结束~~");
    }
}

//需求：学生和老师要一起参加游泳比赛
interface Swimming{
    void swim();
}
