package com.nuc.exam.dao;

import com.nuc.exam.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class AdminDaoTest {
    @Autowired(required = false)
    private AdminDao adminDao;
    @Test
    public void test(){
        Admin admin = adminDao.queryAdmin("ally");
        System.out.println(admin.toString());
    }

}