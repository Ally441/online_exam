package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Answear;
import com.nuc.exam.service.AnswearService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class AnswearServiceImplTest {
    @Autowired
    private AnswearService answearService;

    @Test
    public void insertAnswear() {
        Answear answear = new Answear();
        answear.setAnswear("dui1");
        answear.setExamId(1);
        answear.setQuestionId(1);
        answear.setStudentNumber("1507084139");
        answearService.insertAnswear(answear);
    }

    @Test
    public void submitAnswear() {
        Answear answear = new Answear();
        answear.setAnswear("fdasjasdfkdas");
        answear.setScore(2);
        answear.setExamId(1);
        answear.setQuestionId(1);
        answear.setStudentNumber("1507084139");
        answearService.submitAnswear(answear);
    }

    @Test
    public void giveScore() {
        Answear answear = new Answear();
        answear.setScore(5);
        answear.setExamId(1);
        answear.setQuestionId(1);
        answear.setStudentNumber("1507084139");
        answearService.giveScore(answear);
    }

    @Test
    public void selectAnswear() {
        System.out.println(answearService.selectAnswear(1,"1507084139").toString());
    }

    @Test
    public void selectScore() {
        System.out.println(answearService.selectScore(1,"1507084139"));
    }
}