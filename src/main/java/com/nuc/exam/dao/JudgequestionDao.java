package com.nuc.exam.dao;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Judgequestion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("judgequestionDao")
public interface JudgequestionDao {

    public int insertJudgequestion(Judgequestion judgequestion);

    public int deleteJudgequestion(Integer questionId);

    public int updateJudgequestion(Judgequestion judgequestion);

    public List<Judgequestion> selectJudgequestion(String questionChapter);

    public Judgequestion selectById(Integer questionId);

    public void InputExcel(Map<String,Object> ginsenMap);

    List<Judgequestion> getAll();

}
