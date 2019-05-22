package com.nuc.exam.service;

import com.nuc.exam.entity.Admin;

public interface AdminService {
    public Admin login(String adminName, String adminPassword);

    public boolean updatePassword(String adminName,String adminPassword);
}
