package com.nuc.exam.service.impl;

import com.nuc.exam.dao.JudgequestionDao;
import com.nuc.exam.entity.Judgequestion;
import com.nuc.exam.service.JudgequestionService;
import com.nuc.exam.util.Excel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("judgequestionService")
public class JudgequestionServiceImpl implements JudgequestionService {
    @Autowired
    private JudgequestionDao judgequestionDao;
    @Override
    public int addJudgequestion(Judgequestion judgequestion) {
        return judgequestionDao.insertJudgequestion(judgequestion);
    }

    @Override
    public int deleteJudgequestion(Integer questionId) {
        return judgequestionDao.deleteJudgequestion(questionId);
    }

    @Override
    public int updateJudgequestion(Judgequestion judgequestion) {
        return judgequestionDao.updateJudgequestion(judgequestion);
    }

    @Override
    public List<Judgequestion> selectJudgequestion(String questionChapter) {
        return judgequestionDao.selectJudgequestion(questionChapter);
    }

    @Override
    public Judgequestion selectById(Integer questionId) {
        return judgequestionDao.selectById(questionId);
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
            judgequestionDao.InputExcel(ginsenMap);
        }
        return  "01";
    }

    @Override
    public List<Judgequestion> OutputExcel() {
        return judgequestionDao.getAll();
    }
}
