package com.nuc.exam.service;

import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.entity.Student;
import com.nuc.exam.util.PageBean;

import java.io.InputStream;
import java.util.List;

public interface StudentService {

    public Student login(String studentNumber,String studentPassword);

    public int reigster(Student student);

    public int updateStudent(Student student);//更新学生密码

    public int update(Student student);//修改学生信息

    public void deleteByStudentId(int studentId);

    public List<Student> queryStudentByClass(String studentClass);

    public List<Student> queryStudentByClassName(String studentClassName);

    public String InputExcel(InputStream is, String originalFilename);

    public List<Student>  OutputExcel();

    public List<Student> selectAll();

    public PageBean<Student> findByPage(int currentPage);

    public Student selectByStudentId(int studentId);
}
