package com.nuc.exam.service;

import com.nuc.exam.entity.Exam;

import java.util.List;

public interface ExamService {

    public int addExam(Exam exam);

    public int deleteExam(Integer examId);

    public int updateExam(Exam exam);

    public Exam selectExam(Integer examId);

    public List<Exam> selectAll();

    public List<Exam> selectByClassName(String examClassName);

    public List<Exam> selectByCreater(String examCreater);


}
