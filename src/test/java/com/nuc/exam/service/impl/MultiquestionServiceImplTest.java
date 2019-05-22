package com.nuc.exam.service.impl;

import com.nuc.exam.entity.Multiquestion;
import com.nuc.exam.service.MultiquestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class MultiquestionServiceImplTest {
    @Autowired
    private MultiquestionService multiquestionService;

    @Test
    public void addMultiquestion() {
        Multiquestion multiquestion = new Multiquestion();
        multiquestion.setQuestionName("你还是大幅");
        multiquestion.setAnswear("A");
        multiquestion.setQuestionContext("dsabfjkasdhkf");
        multiquestion.setLevel(1);
        multiquestion.setQuestionA("A");
        multiquestion.setQuestionB("B");
        multiquestion.setQuestionC("C");
        multiquestion.setQuestionD("D");
        multiquestion.setQuestionChapter("第一章");
        multiquestion.setScore(4);

        multiquestion.setQuestionName("Java");
        multiquestionService.addMultiquestion(multiquestion);
    }
    @Test
    public void test(){
        System.out.println(multiquestionService.selectById(1).getScore());
    }

    @Test
    public void deleteMultiquestion() {
        multiquestionService.deleteMultiquestion(1);
    }

    @Test
    public void updateMultiquestion() {
        Multiquestion multiquestion = new Multiquestion();
        multiquestion.setQuestionName("asdlkjlwfe");
        multiquestion.setQuestionChapter("第二张");
        multiquestion.setQuestionId(1);
        multiquestionService.updateMultiquestion(multiquestion);
    }
    @Test
    public void select(){
        System.out.println(multiquestionService.selectMultiquestion("第一章"));
    }
}