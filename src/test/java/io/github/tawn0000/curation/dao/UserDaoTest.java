package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.User;
import javafx.application.Application;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
@MapperScan("io.github.tawn0000.curation")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testAqueryUser() {
        List<User> userList = userDao.queryUser();
        System.out.println(userList.get(0).getuId());
        assertEquals(2, userList.size());
    }

    @Test
    @Ignore
    public void testqueryUserByid() {
        User user = userDao.queryUserById(2L);
        System.out.println(user.getuName());
        assertEquals(Long.valueOf(2), user.getuId());
    }

    @Test
    @Ignore
    public void insertUser() {
        //创建一个用户对象
        User user = new User("fab123456","张宇","男","1.jpg","开","否","复古");
        //将该对象实例添加入库
        List<User> userList1 = userDao.queryUser();
        //校验总数是否+1
        List<User> userList2 = userDao.queryUser();
        assertEquals(userList1.size()+1, userList2.size());
    }

    @Test
    @Ignore
    public void updateUser() {
    }

    @Test
    @Ignore
    public void deleteUser() {
    }
}