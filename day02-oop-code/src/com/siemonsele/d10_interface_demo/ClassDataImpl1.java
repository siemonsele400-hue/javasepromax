package com.siemonsele.d10_interface_demo;


import java.util.ArrayList;

/**
 * 第一套实现类
 */
public class ClassDataImpl1 implements ClassData{
    private ArrayList<Student> students;
    public ClassDataImpl1(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public void printAllStudentOnfos() {
        System.out.println("===展示全部学生信息===");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
        }
    }

    @Override
    public void printAllStudentAverageScores() {
        System.out.println("===展示全部学生的平均分===");
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            allScore += s.getScore();
        }
        System.out.println(allScore / students.size());
    }
}
