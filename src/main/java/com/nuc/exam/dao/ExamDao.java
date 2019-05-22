package com.nuc.exam.dao;

import com.nuc.exam.entity.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("examDao")
public interface ExamDao {
    public int insertExam(Exam exam);

    public int deleteExam(Integer examId);

    public int update(Exam exam);

    public Exam selectExam(Integer examId);

    public List<Exam> selectAll();

    public List<Exam> selectByClassName(String examClassName);

    public List<Exam> selectByCreater(String examCreater);
}
