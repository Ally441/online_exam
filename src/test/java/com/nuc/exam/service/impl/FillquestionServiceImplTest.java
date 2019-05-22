package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Fillquestion;
import com.nuc.exam.service.FillquestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class FillquestionServiceImplTest {
    @Autowired
    private FillquestionService fillquestionService;
    @Test
    public void addFillquestion() {
        Fillquestion fillquestion =new Fillquestion();
        fillquestion.setLevel(0);
        fillquestion.setAnswear("你参");
        fillquestion.setQuestionChapter("第一章");
        fillquestion.setQuestionContext("Java");
        fillquestion.setQuestionName("第一天");
        fillquestion.setScore(5);
        System.out.println(fillquestionService.addFillquestion(fillquestion));
    }
    @Test
    public void test(){
        System.out.println(fillquestionService.selectById(20000).getScore());
    }
    @Test
    public void updateFillquestion() {
        Fillquestion fillquestion =new Fillquestion();
        fillquestion.setQuestionId(1);
        fillquestion.setLevel(1);
        fillquestion.setQuestionChapter("第一章");
        fillquestion.setQuestionName("第一天");
        System.out.println(fillquestionService.updateFillquestion(fillquestion));
    }
    @Test
    public void delete(){
        System.out.println(fillquestionService.deleteFillquestion(2));
    }
    @Test
    public void select(){
        System.out.println(fillquestionService.selectFillquestion("第一章").toString());
    }
}