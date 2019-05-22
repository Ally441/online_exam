package com.nuc.exam.dao;

import com.nuc.exam.entity.Student;
import com.nuc.exam.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("teacherDao")
public interface TeacherDao {

    public Teacher queryTeacher(String teacherName);

    public int registerTeacher(Teacher teacher);

    public int updateTeacherPassword(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public int deleteByTeacherId(Integer teacherId);

    public Teacher queryTeacherById(Integer teacherId);

    public List<Teacher> selectAll();

    /**
     * 分页
     * @param hashMap
     * @return
     */
    public List<Teacher> findByPage(HashMap<String,Object> hashMap);

    public int selectCount();
}
