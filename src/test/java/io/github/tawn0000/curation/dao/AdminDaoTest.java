package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Admin;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    @Ignore
    public void queryAdmin() {
        List<Admin> adminList = adminDao.queryAdmin();
        System.out.println(adminList.get(0).getaId());
        assertEquals(2, adminList.size());
    }

    @Test
    @Ignore
    public void queryAdminByid() {
        Admin admin = adminDao.queryAdminByid(1);
        System.out.println(admin.getaName());
        assertEquals(2,admin.getaId());
    }

    @Test
    @Ignore
    public void insertAdmin() {
       List<Admin> adminList1 = adminDao.queryAdmin();
       //创建一个Admin对象
        Admin admin = new Admin("zhangyu123","zy1555","张宇",2);
        //将对象插入其中
        adminDao.insertAdmin(admin);
        //检验总数是否加一
        List<Admin> adminList2 = adminDao.queryAdmin();
        assertEquals(adminList1.size()+1,adminList2.size());
    }

    @Test
    @Ignore
    public void updateAdmin() {
        Admin admin = new Admin(4,"zhangyu332","zy1555","张宇",2);
        adminDao.updateAdmin(admin);
        System.out.println(adminDao.queryAdminByid(4).getWcId());
    }

    @Test
    @Ignore
    public void deleteAdmin() {
        adminDao.deleteAdmin(4);
        queryAdmin();
    }
}