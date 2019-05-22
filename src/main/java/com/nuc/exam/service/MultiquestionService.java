package com.nuc.exam.service;

import com.nuc.exam.entity.Judgequestion;
import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.entity.Student;
import com.nuc.exam.util.PageBean;

import java.io.InputStream;
import java.util.List;

public interface MultiquestionService {

    public int addMultiquestion(Multiquestion multiquestion);

    public int deleteMultiquestion(Integer questionId);

    public int updateMultiquestion(Multiquestion multiquestion);

    public List<Multiquestion> selectMultiquestion(String questionChapter);

    public Multiquestion selectById(Integer questionId);

    public String InputExcel(InputStream is, String originalFilename);

    public List<Multiquestion>  OutputExcel();

    public PageBean<Multiquestion> findByPage(int currentPage);
}
