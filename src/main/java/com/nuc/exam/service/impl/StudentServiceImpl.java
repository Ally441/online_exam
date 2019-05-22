package com.nuc.exam.service.impl;

import com.nuc.exam.dao.StudentDao;
import com.nuc.exam.entity.Student;
import com.nuc.exam.service.StudentService;
import com.nuc.exam.util.Excel;
import com.nuc.exam.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student login(String studentNumber, String studentPassword) {
        Student student = studentDao.queryStudent(studentNumber,studentPassword);
        return student;
    }

    @Override
    public int reigster(Student student) {
        return studentDao.registerStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudentPassword(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public void deleteByStudentId(int studentId) {
        studentDao.deleteByStudentId(studentId);
    }

    @Override
    public List<Student> queryStudentByClass(String studentClass) {
        return studentDao.queryStudentByClass(studentClass);
    }

    @Override
    public List<Student> queryStudentByClassName(String studentClassName) {
        return studentDao.queryStudentByClassName(studentClassName);
    }

    @Override
    public String InputExcel(InputStream is, String originalFilename) {
        Map<String,Object> ginsenMap=new HashMap<String, Object>();
        List<ArrayList<Object>> list;
        if(originalFilename.endsWith(".xls")){
            list= Excel.readExcel2003(is);
        }else{
            list=Excel.readExcel2007(is);
        }
        for(int i=0,j=list.size();i<j;i++){
            List<Object> row = list.get(i);
            ginsenMap.put("studentNumber",row.get(1).toString());
            ginsenMap.put("studentName",row.get(2).toString());
            ginsenMap.put("studentPassword",row.get(3).toString());
            ginsenMap.put("studentClass",row.get(4).toString());
            ginsenMap.put("studentClassName",row.get(5).toString());
            ginsenMap.put("studentPhone",row.get(6).toString());
            ginsenMap.put("studentEmail",row.get(7).toString());
            System.out.println(row.get(8).toString());
            if(row.get(8).toString().equals("男")){
                ginsenMap.put("studentSex",true);
            }else{
                ginsenMap.put("studentSex",false);
            }

            studentDao.InputExcel(ginsenMap);
        }
        return  "01";
    }

    @Override
    public List<Student> OutputExcel() {
        return studentDao.getAll();
    }

    @Override
    public List<Student> selectAll() {
        return studentDao.getAll();
    }

    @Override
    public PageBean<Student> findByPage(int currentPage) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        PageBean<Student> pageBean=new PageBean<Student>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=studentDao.selectCount();
        pageBean.setCount(totalCount);
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        hashMap.put("start",(currentPage-1)*pageSize);
        hashMap.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Student> studentList=studentDao.findByPage(hashMap);
        pageBean.setList(studentList);
        return pageBean;
    }

    @Override
    public Student selectByStudentId(int studentId) {
        return studentDao.selectByStudentId(studentId);
    }
}
