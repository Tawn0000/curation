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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testAqueryUserByid() {
        User user = userDao.queryUserById(2L);
        System.out.println(user.getuName());
        assertEquals(Long.valueOf(2), user.getuId());
    }

    @Test
    @Ignore
    public void insertUser() {
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