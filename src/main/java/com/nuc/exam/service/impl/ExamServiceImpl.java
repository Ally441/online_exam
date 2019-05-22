package com.nuc.exam.service.impl;

import com.nuc.exam.dao.ExamDao;
import com.nuc.exam.entity.Exam;
import com.nuc.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("examService")
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;
    @Override
    public int addExam(Exam exam) {
        return examDao.insertExam(exam);
    }

    @Override
    public int deleteExam(Integer examId) {
        return examDao.deleteExam(examId);
    }

    @Override
    public int updateExam(Exam exam) {
        return examDao.update(exam);
    }

    @Override
    public Exam selectExam(Integer examId) {
        return examDao.selectExam(examId);
    }

    @Override
    public List<Exam> selectAll() {
        return examDao.selectAll();
    }

    @Override
    public List<Exam> selectByClassName(String examClassName) {
        return examDao.selectByClassName(examClassName);
    }

    @Override
    public List<Exam> selectByCreater(String examCreater) {
        return examDao.selectByCreater(examCreater);
    }
}
