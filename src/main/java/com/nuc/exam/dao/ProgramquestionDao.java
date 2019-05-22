package com.nuc.exam.dao;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Programquestion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("programquestionDao")
public interface ProgramquestionDao {

    public int insertProgramquestion(Programquestion programquestion);

    public int updateProgramquestion(Programquestion programquestion);

    public int deleteProgramquestion(Integer questionId);

    public List<Programquestion> selectProgramquestion(String questionChapter);

    public Programquestion selectById(Integer questionId);

    public void InputExcel(Map<String,Object> ginsenMap);

    List<Programquestion> getAll();
}
