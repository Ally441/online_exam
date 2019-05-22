package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Judgequestion;
import com.nuc.exam.service.JudgequestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class JudgequestionServiceImplTest {

    @Autowired
    private JudgequestionService judgequestionService;
    @Test
    public void addJudgequestion() {
        Judgequestion judgequestion = new Judgequestion();
        judgequestion.setQuestionName("第一章");
        judgequestion.setAnswear(true);
        judgequestion.setLevel(1);
        judgequestion.setQuestionChapter("第一章");
        judgequestion.setScore(2);
        judgequestion.setQuestionContext("Hello world");
        System.out.println(judgequestionService.addJudgequestion(judgequestion));
    }
    @Test
    public void test(){
        System.out.println(judgequestionService.selectById(30000));
    }
    @Test
    public void deleteJudgequestion() {
        System.out.println(judgequestionService.deleteJudgequestion(1));
    }

    @Test
    public void updateJudgequestion() {
        Judgequestion judgequestion = new Judgequestion();
        judgequestion.setQuestionChapter("第二张");
        judgequestion.setQuestionId(1);
        judgequestion.setLevel(2);
        judgequestionService.updateJudgequestion(judgequestion);
    }
    @Test
    public void test1(){
        System.out.println(judgequestionService.selectJudgequestion("第一章").toString());
    }
}