package com.nuc.exam.service;

import com.nuc.exam.entity.Student;
import com.nuc.exam.entity.Teacher;
import com.nuc.exam.util.PageBean;

import java.util.List;

public interface TeacherService {

    public Teacher selectById(Integer teacherId);

    public boolean login(String teacherNumber,String teacherPassword);

    public int register(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public int update(Teacher teacher);

    public List<Teacher> selectAll();

    public PageBean<Teacher> findByPage(int currentPage);

    public int deleteByTeacherId(int teacherId);
}
