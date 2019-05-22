package com.nuc.exam.service.impl;

import com.nuc.exam.dao.AdminDao;
import com.nuc.exam.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
//    @Test
//    public void testlogin() {
//        if(adminService.login("ally","123")){
//            System.out.println("登录成功");
//        }else{
//            System.out.println("登陆失败" );
//        }
//    }

    @Test
    public void testupdatePassword() {
        adminService.updatePassword("ally","073018");
    }
}