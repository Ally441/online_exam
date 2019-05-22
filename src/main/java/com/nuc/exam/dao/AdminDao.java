package com.nuc.exam.dao;

import com.nuc.exam.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public interface AdminDao {
    /**
     * 登录
     * @param adminName
     * @return
     */
    public Admin queryAdmin(@Param("adminName") String adminName);

    /**
     * 更改密码
     * @param adminName
     * @param adminPassword
     * @return
     */
    public int updateAdmin(@Param("adminName")String adminName,@Param("adminPassword") String adminPassword);
}
