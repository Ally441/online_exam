package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Grade;
import com.nuc.exam.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class GradeServiceImplTest {
    @Autowired
    private GradeService gradeService;
    @Test
    public void addGrade() {
        Grade grade = new Grade();
        grade.setGradeClass("15070841");
        grade.setGradeClassName("网络工程");
        grade.setGradeExamId(1);
        grade.setGradeScore(80);
        grade.setGradeStudentNumber("1507084141");
        gradeService.addGrade(grade);
    }

    @Test
    public void updateGrade() {
        Grade grade = new Grade();
        grade.setGradeExamId(1);
        grade.setGradeStudentNumber("1507084139");
        grade.setGradeScore(100);
        gradeService.updateGrade(grade);
    }

    @Test
    public void deleteGrade() {
        Grade grade = new Grade();
        grade.setGradeExamId(1);
        grade.setGradeStudentNumber("1507084141");
        gradeService.deleteGrade(grade);
    }

    @Test
    public void selectByClassAndExam() {
        System.out.println(gradeService.selectByClassAndExam(1,"15070841").toString());
    }

    @Test
    public void selectByStudentNumber() {
        System.out.println(gradeService.selectByStudentNumber("1507084139").toString());
    }
    @Test
    public void test(){
        System.out.println(gradeService.selectByStudentNumberAndExamId(1,"1507084139"));
    }
}