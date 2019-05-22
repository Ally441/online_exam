package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Programquestion;
import com.nuc.exam.service.ProgramquestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class ProgramquestionServiceImplTest {
    @Autowired
    ProgramquestionService programquestionService;
    @Test
    public void addProgramquestion() {
        Programquestion programquestion = new Programquestion();
        programquestion.setAnswear("1");
        programquestion.setLevel(1);
        programquestion.setQuestionChapter("first");
        programquestion.setQuestionContext("contex");
        programquestion.setQuestionName("编程图");
        programquestion.setScore(20);
        programquestionService.addProgramquestion(programquestion);
    }

    @Test
    public void deleteProgramquestion() {
        programquestionService.deleteProgramquestion(1);
    }

    @Test
    public void updateProgramquestion() {
        Programquestion programquestion = new Programquestion();
        programquestion.setScore(10);
        programquestion.setLevel(2);
        programquestion.setQuestionId(1);
        programquestionService.updateProgramquestion(programquestion);
    }
    @Test
    public void test(){
        System.out.println(programquestionService.selectProgramquestion("first").toString());
    }
}