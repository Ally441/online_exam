package com.nuc.exam.service;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Judgequestion;

import java.io.InputStream;
import java.util.List;

public interface JudgequestionService {

    public int addJudgequestion(Judgequestion judgequestion);

    public int deleteJudgequestion(Integer questionId);

    public int updateJudgequestion(Judgequestion judgequestion);

    public List<Judgequestion> selectJudgequestion(String questionChapter);

    public Judgequestion selectById(Integer questionId);

    public String InputExcel(InputStream is, String originalFilename);

    public List<Judgequestion>  OutputExcel();
}
