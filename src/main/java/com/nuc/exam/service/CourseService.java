package com.nuc.exam.service;

import com.nuc.exam.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

//    public Course selectCourseByCourseId(Integer courseId);

    public Course selectDetail(String courseName);

    public List<Course> selectCourseByTeacherId(Integer teacherId);

    public List<Course> selectCourseByClassName(String courseClassName);

    public int insertCourse(Course course);

    public int deleteCourse(Integer courseId);

}
