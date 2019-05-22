package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Teacher;
import com.nuc.exam.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class TeacherServiceImplTest {
    @Autowired
    private TeacherService teacherService;
    @Test
    public void login() {
        if(teacherService.login("1001","123456")){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    @Test
    public void register() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNumber("1004");
        teacher.setTeacherPassword("123456");
        teacher.setTeacherName("Marry");
        System.out.println(teacherService.register(teacher));
    }

    @Test
    public void updateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNumber("1004");
        teacher.setTeacherPassword("1004");
        teacherService.updateTeacher(teacher);
    }
}