package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.AdminDao;
import io.github.tawn0000.curation.entity.Admin;
import io.github.tawn0000.curation.service.AdminService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@MapperScan("io.github.tawn0000.curation")

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> queryAdmin(){
        //返回所有的管理员信息
        return adminDao.queryAdmin();
    }

    @Override
    public Admin queryAdminByid(int adminId){
        //根据管理员id获取管理员信息
        return adminDao.queryAdminByid(adminId);
    }

    @Transient
    @Override
    public Boolean insertAdmin(Admin admin){
        //空值判断，主要是判断wcId是否为空
        if (admin.getWcId() != null && !"".equals(admin.getWcId()))
        {
            try {
                adminDao.insertAdmin(admin);
            }
            catch (Exception e){
                throw new RuntimeException("添加管理员信息失败" + e.toString());
            }
        }
        else
        {
            throw new RuntimeException("管理员信息不能为空" );
        }

        return true;
    }

    @Transient
    @Override
    public  Boolean updateAdmin(Admin admin){
        if(admin.getaId() != null && admin.getaId() > 0){
            try {
                adminDao.updateAdmin(admin);
            }
            catch (Exception e){
                throw new RuntimeException("更新管理员信息失败" + e.toString());
            }
        }
        else {
            throw new RuntimeException("管理员信息为空");
        }
        return true;
    }

    @Transient
    @Override
    public Boolean deleteAdmin(int adminId){
        if (adminId > 0)
        {
            try{
                adminDao.deleteAdmin(adminId);
            }
            catch (Exception e){
                throw new RuntimeException("删除信息失败" + e.toString());
            }
        }
        else {
            throw new RuntimeException("管理员adminId不能为空");
        }
        return true;
    }
}
