package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Course;
import com.nuc.exam.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void selectDetail() {
        System.out.println(courseService.selectDetail("Java").toString());
    }

    @Test
    public void selectCourseByTeacherId() {
        System.out.println(courseService.selectCourseByTeacherId(1));
    }

    @Test
    public void selectCourseByClassName() {
        List<Course> list= courseService.selectCourseByClassName("网络工程");
        for(Course course:list)
            System.out.println(course.getTeacher().toString());
    }

    @Test
    public void insertCourse() {
        Course course = new Course();
        course.setCourseName("Java");
        course.setCourseClassName("网络工程");
        course.setCourseStartTime(new Date());
        course.setCourseEndTime(new Date());
        course.setCourseTeacherId(1);
        courseService.insertCourse(course);
    }
    @Test
    public void test(){
        courseService.deleteCourse(1);
    }
}