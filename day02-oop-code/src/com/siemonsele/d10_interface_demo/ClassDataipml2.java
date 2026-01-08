package com.siemonsele.d10_interface_demo;

import java.util.ArrayList;

public class ClassDataipml2 implements ClassData {
    private ArrayList<Student> students;
    public ClassDataipml2(ArrayList<Student> students) {
        this.students = students;
    }
    @Override
    public void printAllStudentOnfos(){
        System.out.println("==展示学生全部信息==");
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
            if(s.getSex() == '男')count++;
        }
        System.out.println("男人数：" + count);
        System.out.println("女生数：" + (students.size()-count));
    }

    @Override
    public void printAllStudentAverageScores(){
        System.out.println("==展示学生的平均分==");
        Student s1 = students.get(0);
        double score = s1.getScore();
        double allScore = score;
        double max =  score;
        double min = score;
        for (int i = 1; i < students.size(); i++) {
            Student s = students.get(i);
            double score1 = s.getScore();
            allScore += score1;
            if(score1 > max)max=score1;
            if(score1<min)min=score1;
        }
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("平均分：" + (allScore - max - min) / (students.size()-2));
    }
}
















