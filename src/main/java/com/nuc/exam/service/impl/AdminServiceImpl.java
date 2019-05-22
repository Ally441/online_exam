package com.nuc.exam.service.impl;


import com.nuc.exam.dao.AdminDao;
import com.nuc.exam.entity.Admin;
import com.nuc.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    public Admin login(String adminName, String adminPassword) {
        Admin admin = adminDao.queryAdmin(adminName);
        return admin;
    }

    @Override
    public boolean updatePassword(String adminName, String adminPassword) {
        int number= adminDao.updateAdmin(adminName,adminPassword);
        if(number<=0){
            return false;
        }else {
            return true;
        }
    }
}
