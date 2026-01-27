package com.siemonsele.d11_object;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * 比较者：  t1 ==> this
     * 被比较者： t2 ==> o
     */
    @Override
    public boolean equals(Object o) {
        // 1、判断两个对象是否是同一个对象在比较，如果是，直接返回true
        if (this == o) return true;
        // 2、判断o如果是null,直接返回false，或者两个对象的类型的不一样也直接返回false。
        //                Student.class  !=    pig.class
        if (o == null || this.getClass() != o.getClass()) return false;
        // 3、说明两个对象肯定都是学生类型，且是不同对象，开始比较内容了！
        Student student = (Student) o;
        return this.age == student.age && Double.compare(this.score, student.score) == 0 &&
                Objects.equals(this.name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

}
