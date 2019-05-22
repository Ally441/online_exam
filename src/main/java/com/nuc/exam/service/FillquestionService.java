package com.nuc.exam.service;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.util.PageBean;

import java.io.InputStream;
import java.util.List;

public interface FillquestionService {
    public int addFillquestion(Fillquestion fillquestion);

    public int updateFillquestion(Fillquestion fillquestion);//修改题目

    public int deleteFillquestion(Integer questionId);

    public List<Fillquestion> selectFillquestion(String questionChapter);

    public Fillquestion selectById(Integer questionId);

    public String InputExcel(InputStream is, String originalFilename);

    public List<Fillquestion>  OutputExcel();

    public PageBean<Fillquestion> findByPage(int currentPage);
}
