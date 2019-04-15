package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Etag;
<<<<<<< HEAD
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
public class EtagDaoTest {
    @Autowired
<<<<<<< HEAD
    private Etag etag;

    @Test
    public void queryEtag() {

=======
    private EtagDao etagDao;

    @Test
    public void testQueryEtag() {
        List<Etag>  etagList = etagDao.queryEtag();
        System.out.println(etagList.size());
>>>>>>> 02f179a4ba62894dec33f10a23655d333588f7a4
    }

    @Test
    public void testQueryEtagByid() {
        Etag etag = etagDao.queryEtagByid(1L);
        System.out.println(etag.geteTags());
    }

    @Test
    public void testInsertEtag() {
        Etag etag = new Etag(1L,"复古");
        etagDao.insertEtag(etag);
    }

    @Test
    public void testUpdateEtag() {
        Etag etag = new Etag(1L,1L,"文艺");
        etagDao.updateEtag(etag);
        testQueryEtagByid();
    }

    @Test
    public void testDeleteEtag() {
        etagDao.deleteEtag(1L);

    }
}