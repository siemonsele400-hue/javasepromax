package com.siemonsele.d12_objects;

import com.siemonsele.d11_object.Student;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        //目标：掌握Objects的常用方法
        Student t1 = null;
        Student t2 = new Student("蜘蛛精", 300, 98);

        //System.out.println(t1.equals(t2));  如果主调对象是null，直接爆出空指针异常

        /*public static boolean equals(Object a, Object b){
            return (a == b) || (a != null && a.equals(b));
        }*/
        //更安全，更可靠，推荐使用false
        //今后比较两个对象时，建议用Objects的equals来判断
        System.out.println(Objects.equals(t1, t2));

        System.out.println(Objects.isNull(t1));  //true
        System.out.println(t1 == null); //true
        System.out.println(Objects.nonNull(t1)); //false
        System.out.println(t1 != null); //false

    }
}
