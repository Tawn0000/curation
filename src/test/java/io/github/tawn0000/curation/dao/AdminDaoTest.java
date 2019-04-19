package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Admin;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
@MapperScan("io.github.tawn0000.curation")
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    public void testQueryAdmin() {
        List<Admin> adminList = adminDao.queryAdmin();
        System.out.println(adminList.get(0).getaId());
        assertEquals(1, adminList.size());
    }
    @Test
    public void testQueryAdminById() {
        Admin admin = adminDao.queryAdminById(1);
        System.out.println(admin.getaName());
    }

    @Test
    public void testInsertAdmin() {
        List<Admin> adminList1 = adminDao.queryAdmin();
        //创建一个Admin对象
        Admin admin = new Admin("zhangyu123","zy1555","张宇",1);
        //将对象插入其中
        adminDao.insertAdmin(admin);
        //检验总数是否加一
        List<Admin> adminList2 = adminDao.queryAdmin();
        assertEquals(adminList1.size()+1,adminList2.size());
    }

    @Test
    public void testUpdateAdmin() {
        Admin admin = new Admin(1,"zhangyu235553","zy1555","张宇",1);
        adminDao.updateAdmin(admin);
        System.out.println(admin.getOpenId());
    }

    @Test
    public void testDeleteAdmin() {
        adminDao.deleteAdmin(1);
        testQueryAdmin();
    }
}