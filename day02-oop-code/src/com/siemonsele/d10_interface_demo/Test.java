package com.siemonsele.d10_interface_demo;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //目标：班级学生管理系统
        //1.每个学生是一个对象，所以先定义学生类，用于创建学生对象，封装学生数据
        //2.定义接口：ClassData
        //3，定义两套实现类，来分别处理，以便解耦合
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("木婉清", '女', 80));
        students.add(new Student("钟灵", '女', 95));
        students.add(new Student("王语嫣", '女', 75));
        students.add(new Student("西夏公主", '女', 100));
        students.add(new Student("虚竹", '男', 90));
        students.add(new Student("乔峰", '男', 100));
        students.add(new Student("段誉", '男', 80));

        ClassData data = new ClassDataImpl1(students);
        data.printAllStudentOnfos();
        data.printAllStudentAverageScores();

        ClassData data1 = new ClassDataipml2(students);
        data1.printAllStudentOnfos();
        data1.printAllStudentAverageScores();
    }
}
