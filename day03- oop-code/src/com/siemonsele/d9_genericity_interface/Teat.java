package com.siemonsele.d9_genericity_interface;

public class Teat {
    public static void main(String[] args) {
        //目标：认识泛型接口的使用架构
        //需求：必须完成学生，老师数据的增删改查操作

        // 1. Create a StudentData object to handle Student operations
        Data<Student> studentData = new StudentData();
        studentData.add(new Student("Zhang San"));
        studentData.delete(1);

        // 2. Create a TeacherData object to handle Teacher operations
        Data<Teacher> teacherData = new TeacherData();
        teacherData.add(new Teacher("Li Si"));
        teacherData.update(new Teacher("Li Si (Promoted)"));
    }
}
