package com.nuc.exam.service.impl;

import com.nuc.exam.dao.CourseDao;
import com.nuc.exam.entity.Course;
import com.nuc.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

//    @Override
//    public Course selectCourseByCourseId(Integer courseId) {
//        return courseDao.queryCourseId(courseId);
//    }

    @Override
    public Course selectDetail(String courseName) {

        return courseDao.queryCourse(courseName);
    }

    @Override
    public List<Course> selectCourseByTeacherId(Integer teacherId) {
        return courseDao.queryCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> selectCourseByClassName(String courseClassName) {
        return courseDao.queryCourseByClassName(courseClassName);
    }

    @Override
    public int insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public int deleteCourse(Integer courseId) {
        return courseDao.deleteCourse(courseId);
    }


}
