package com.nuc.exam.service;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Programquestion;

import java.io.InputStream;
import java.util.List;

public interface ProgramquestionService {

    public int addProgramquestion(Programquestion programquestion);

    public int deleteProgramquestion(Integer questionId);

    public int updateProgramquestion(Programquestion programquestion);

    public List<Programquestion> selectProgramquestion(String questionChapter);

    public Programquestion selectById(Integer questionId);

    public String InputExcel(InputStream is, String originalFilename);

    public List<Programquestion>  OutputExcel();
}
