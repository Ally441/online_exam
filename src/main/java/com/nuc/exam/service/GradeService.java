package com.nuc.exam.service;

import com.nuc.exam.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeService {

    public int addGrade(Grade grade);

    public int updateGrade(Grade grade);

    public int deleteGrade(Grade grade);

    public Grade selectByStudentNumberAndExamId(Integer gradeExamId,String gradeStudentNumber);

    public List<Grade> selectByClassAndExam(Integer gradeExamId, String gradeClass );

    public List<Grade> selectByStudentNumber(String gradeStudentNumber);
}
