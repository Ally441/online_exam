package com.nuc.exam.service.impl;

import com.nuc.exam.dao.FillquestionDao;
import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.service.FillquestionService;
import com.nuc.exam.util.Excel;
import com.nuc.exam.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("fillquestionService")
public class FillquestionServiceImpl implements FillquestionService {
    @Autowired
    private FillquestionDao fillquestionDao;
    @Override
    public int addFillquestion(Fillquestion fillquestion) {
        return fillquestionDao.insertFillquestion(fillquestion);
    }

    @Override
    public int updateFillquestion(Fillquestion fillquestion) {
        return fillquestionDao.updateFillquestion(fillquestion);
    }

    @Override
    public int deleteFillquestion(Integer questionId) {
        return fillquestionDao.deleteFillquestion(questionId);
    }

    @Override
    public List<Fillquestion> selectFillquestion(String questionChapter) {
        return fillquestionDao.selectFillquestion(questionChapter);
    }

    @Override
    public Fillquestion selectById(Integer questionId) {
        return fillquestionDao.selectById(questionId);
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
            ginsenMap.put("questionName",row.get(1).toString());
            ginsenMap.put("questionContext",row.get(2).toString());
            ginsenMap.put("answear",row.get(3).toString());
            ginsenMap.put("score",row.get(4).toString());
            ginsenMap.put("questionChapter",row.get(5).toString());
            ginsenMap.put("level",row.get(6).toString());
            fillquestionDao.InputExcel(ginsenMap);
        }
        return  "01";
    }
    @Override
    public List<Fillquestion> OutputExcel() {
        return fillquestionDao.getAll();
    }

    @Override
    public PageBean<Fillquestion> findByPage(int currentPage) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        PageBean<Fillquestion> pageBean=new PageBean<Fillquestion>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount=fillquestionDao.selectCount();
        pageBean.setCount(totalCount);
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        hashMap.put("start",(currentPage-1)*pageSize);
        hashMap.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Fillquestion> fillquestionList=fillquestionDao.findByPage(hashMap);
        pageBean.setList(fillquestionList);
        return pageBean;
    }
}
