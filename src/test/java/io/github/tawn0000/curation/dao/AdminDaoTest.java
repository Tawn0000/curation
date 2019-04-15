package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Admin;
<<<<<<< HEAD
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
>>>>>>> 02f179a4ba62894dec33f10a23655d333588f7a4

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
@MapperScan("io.github.tawn0000.curation")
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;
<<<<<<< HEAD

    @Test
    @Ignore
    public void queryAdmin() {
        List<Admin> adminList = adminDao.queryAdmin();
        System.out.println(adminList.get(0).getaId());
        assertEquals(2, adminList.size());
=======
    @Test
    public void testQueryAdmin() {
        List<Admin> adminList = adminDao.queryAdmin();
        System.out.println(adminList.get(0).getaId());
        assertEquals(1, adminList.size());
>>>>>>> 02f179a4ba62894dec33f10a23655d333588f7a4
    }
    @Test
<<<<<<< HEAD
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
=======
    public void testQueryAdminByid() {
        Admin admin = adminDao.queryAdminByid(1);
        System.out.println(admin.getaName());
        assertEquals(1,admin.getaId());
    }

    @Test
    public void testInsertAdmin() {
        List<Admin> adminList1 = adminDao.queryAdmin();
        //创建一个Admin对象
        Admin admin = new Admin("zhangyu123","zy1555","张宇",1);
>>>>>>> 02f179a4ba62894dec33f10a23655d333588f7a4
        //将对象插入其中
        adminDao.insertAdmin(admin);
        //检验总数是否加一
        List<Admin> adminList2 = adminDao.queryAdmin();
        assertEquals(adminList1.size()+1,adminList2.size());
    }

    @Test
<<<<<<< HEAD
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
=======
    public void testUpdateAdmin() {
        Admin admin = new Admin(3,"zhangyu235553","zy1555","张宇",1);
        adminDao.updateAdmin(admin);
        System.out.println(adminDao.queryAdminByid(3).getWcId());
    }

    @Test
    public void testDeleteAdmin() {
        adminDao.deleteAdmin(3);
        testQueryAdmin();
>>>>>>> 02f179a4ba62894dec33f10a23655d333588f7a4
    }
}