package com.nuc.exam.dao;

import com.nuc.exam.entity.Course;
import com.nuc.exam.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
@Repository("courseDao")
public interface CourseDao {

//    public Course queryCourseId(Integer courseId);

    public Course queryCourse(String courseName);

    public List<Course> queryCourseByTeacherId(Integer teacherId);

    public List<Course> queryCourseByClassName(String courseClassName);

    public int insertCourse(Course course);

    public int deleteCourse(Integer courseId);

}
