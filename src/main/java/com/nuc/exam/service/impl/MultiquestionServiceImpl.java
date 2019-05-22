package com.nuc.exam.service.impl;

import com.nuc.exam.dao.MultiquestionDao;
import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.entity.Student;
import com.nuc.exam.service.MultiquestionService;
import com.nuc.exam.util.Excel;
import com.nuc.exam.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("multiquestionService")
public class MultiquestionServiceImpl implements MultiquestionService {
    @Autowired
    private MultiquestionDao multiquestionDao;

    @Override
    public int addMultiquestion(Multiquestion multiquestion) {
        return multiquestionDao.insertMultiquestion(multiquestion);
    }

    @Override
    public int deleteMultiquestion(Integer questionId) {
        return multiquestionDao.deleteMultiquestion(questionId);
    }

    @Override
    public int updateMultiquestion(Multiquestion multiquestion) {
        return multiquestionDao.updateMultiquestion(multiquestion);
    }

    @Override
    public List<Multiquestion> selectMultiquestion(String questionChapter) {
        return multiquestionDao.selectMultiquestion(questionChapter);
    }

    @Override
    public Multiquestion selectById(Integer questionId) {
        return multiquestionDao.selectById(questionId);
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
            System.out.println(row.toString());
            ginsenMap.put("questionName",row.get(1).toString());
            ginsenMap.put("questionContext",row.get(2).toString());
            ginsenMap.put("questionA",row.get(3).toString());
            ginsenMap.put("questionB",row.get(4).toString());
            ginsenMap.put("questionC",row.get(5).toString());
            ginsenMap.put("questionD",row.get(6).toString());
            ginsenMap.put("answear",row.get(7).toString());
            ginsenMap.put("score",row.get(8).toString());
            ginsenMap.put("level",row.get(9).toString());
            ginsenMap.put("questionChapter",row.get(10).toString());
            multiquestionDao.InputExcel(ginsenMap);
        }
        return  "01";
    }
    @Override
    public List<Multiquestion> OutputExcel() {
        return multiquestionDao.getAll();
    }

    @Override
    public PageBean<Multiquestion> findByPage(int currentPage) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        PageBean<Multiquestion> pageBean=new PageBean<Multiquestion>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=multiquestionDao.selectCount();
        pageBean.setCount(totalCount);
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        hashMap.put("start",(currentPage-1)*pageSize);
        hashMap.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Multiquestion> multiquestionList=multiquestionDao.findByPage(hashMap);
        pageBean.setList(multiquestionList);
        return pageBean;
    }
}
