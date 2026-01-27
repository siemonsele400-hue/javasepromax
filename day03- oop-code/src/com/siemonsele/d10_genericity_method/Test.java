package com.siemonsele.d10_genericity_method;

import com.siemonsele.d9_genericity_interface.Student;

public class Test {
    public static void main(String[] args) {
        // 目标：认识泛型方法。
        // 需求：要求接收任意对象数组。
        String[] names = {"谢霆锋", "陈羽凡", "王宝强", "贾乃亮"};
        String rs1 = printArray(names);

        Student[] students = new Student[60];
        Student rs2 = printArray(students);
    }

    public static <T> T printArray(T[] array){
        return array[0];
    }

}
