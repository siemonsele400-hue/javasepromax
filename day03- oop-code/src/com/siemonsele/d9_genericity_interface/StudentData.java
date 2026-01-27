package com.siemonsele.d9_genericity_interface;

public class StudentData implements Data<Student>{
    @Override
    public void add(Student student) {
        System.out.println("添加学生: " + student);
    }

    @Override
    public void delete(int id) {
        System.out.println("删除学生，ID: " + id);
    }

    @Override
    public void update(Student student) {
        System.out.println("更新学生: " + student);
    }

    @Override
    public Student getById(int id) {
        System.out.println("查询学生，ID: " + id);
        return null;
    }
}
