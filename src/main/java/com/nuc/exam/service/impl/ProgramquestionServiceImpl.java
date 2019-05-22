package com.nuc.exam.service.impl;

import com.nuc.exam.dao.ProgramquestionDao;
import com.nuc.exam.entity.Programquestion;
import com.nuc.exam.service.ProgramquestionService;
import com.nuc.exam.util.Excel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("programquestionService")
public class ProgramquestionServiceImpl implements ProgramquestionService {
    @Autowired
    private ProgramquestionDao programquestionDao;

    @Override
    public int addProgramquestion(Programquestion programquestion) {
        return programquestionDao.insertProgramquestion(programquestion);
    }

    @Override
    public int deleteProgramquestion(Integer questionId) {
        return programquestionDao.deleteProgramquestion(questionId);
    }

    @Override
    public int updateProgramquestion(Programquestion programquestion) {
        return programquestionDao.updateProgramquestion(programquestion);
    }

    @Override
    public List<Programquestion> selectProgramquestion(String questionChapter) {
        return programquestionDao.selectProgramquestion(questionChapter);
    }

    @Override
    public Programquestion selectById(Integer questionId) {
        return programquestionDao.selectById(questionId);
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
            programquestionDao.InputExcel(ginsenMap);
        }
        return  "01";
    }

    @Override
    public List<Programquestion> OutputExcel() {
        return programquestionDao.getAll();
    }
}
