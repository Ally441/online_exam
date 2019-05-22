package com.nuc.exam.service.impl;

import com.nuc.exam.dao.GradeDao;
import com.nuc.exam.entity.Grade;
import com.nuc.exam.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;
    @Override
    public int addGrade(Grade grade) {
        return gradeDao.insertGrade(grade);
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeDao.updateGrade(grade);
    }

    @Override
    public int deleteGrade(Grade grade) {
        return gradeDao.deleteGrade(grade);
    }

    @Override
    public Grade selectByStudentNumberAndExamId(Integer gradeExamId, String gradeStudentNumber) {
        return gradeDao.selectByStudentNumberAndExamId(gradeExamId,gradeStudentNumber);
    }

    @Override
    public List<Grade> selectByClassAndExam(Integer gradeExamId, String gradeClass) {
        return gradeDao.selectByClassAndExam(gradeExamId,gradeClass);
    }

    @Override
    public List<Grade> selectByStudentNumber(String gradeStudentNumber) {
        return gradeDao.selectByStudentNumber(gradeStudentNumber);
    }
}
