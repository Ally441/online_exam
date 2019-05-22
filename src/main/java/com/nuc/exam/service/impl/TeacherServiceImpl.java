package com.nuc.exam.service.impl;

import com.nuc.exam.dao.TeacherDao;
import com.nuc.exam.entity.Student;
import com.nuc.exam.entity.Teacher;
import com.nuc.exam.service.TeacherService;
import com.nuc.exam.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher selectById(Integer teacherId) {
        return teacherDao.queryTeacherById(teacherId);
    }

    @Override
    public boolean login(String teacherNumber, String teacherPassword) {
        if(teacherDao.queryTeacher(teacherNumber).getTeacherPassword().equals(teacherPassword)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int register(Teacher teacher) {
        return teacherDao.registerTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacherPassword(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherDao.selectAll();
    }


    @Override
    public PageBean<Teacher> findByPage(int currentPage) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        PageBean<Teacher> pageBean= new PageBean<Teacher>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=teacherDao.selectCount();
        pageBean.setCount(totalCount);
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        hashMap.put("start",(currentPage-1)*pageSize);
        hashMap.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Teacher> teacherList=teacherDao.findByPage(hashMap);
        pageBean.setList(teacherList);
        return pageBean;
    }

    @Override
    public int deleteByTeacherId(int teacherId) {
        return teacherDao.deleteByTeacherId(teacherId);
    }


}
