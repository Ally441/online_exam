package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Student;
import com.nuc.exam.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void login() {
        if(studentService.login("1507084138","073018")!=null){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
    }

    @Test
    public void reigster() {
        Student student = new Student();
        student.setStudentNumber("1507084141");
        student.setStudentName("张超杰");
        student.setStudentClass("15070841");
        student.setStudentClassName("网络工程");
        student.setStudentPassword("073018");
        student.setStudentSex(true);
        System.out.println(studentService.reigster(student));
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setStudentNumber("1507084140");
        student.setStudentPassword("073011");
        System.out.println(studentService.updateStudent(student));
    }

    @Test
    public void queryStudentByClass() {
        List<Student> list= studentService.queryStudentByClass("15070841");
        for(Student list1:list)
            System.out.println(list1.toString());
    }

    @Test
    public void queryStudentByClassName() {
        List<Student> list = studentService.queryStudentByClassName("网络工程");
        for(Student list1:list)
            System.out.println(list1.toString());
    }
}