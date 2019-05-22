package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Exam;
import com.nuc.exam.service.ExamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ExamServiceImplTest {
    @Autowired
    private ExamService examService;
    @Test
    public void addExam() {
        Exam exam = new Exam();
        exam.setExamName("test");
        exam.setExamCreater("Jack");
        exam.setExamContext("gasdjsdahflhsadfsdja");
        exam.setExamStatus(1);
        exam.setExamTime("90");
        exam.setExamClassName("网络工程");
        examService.addExam(exam);
    }

    @Test
    public void deleteExam() {

    }

    @Test
    public void updateExam() {
        Exam exam = new Exam();
        exam.setExamName("test");
        exam.setExamCreater("Jack");
        exam.setExamContext("gasdjsdahflhsadfsdja");
        exam.setExamStatus(0);
        exam.setExamTime("80");
        exam.setExamClassName("网络工程");
        exam.setExamId(1);
        examService.updateExam(exam);
    }

    @Test
    public void selectExam() {
        System.out.println(examService.selectExam(1).toString());
    }

    @Test
    public void selectAll() {
        System.out.println(examService.selectAll());
    }

    @Test
    public void selectByClassName() {
        System.out.println(examService.selectByClassName("网络工程").toString());
    }
    @Test
    public void test(){
        System.out.println(examService.selectByCreater("jack").toString());
    }
}