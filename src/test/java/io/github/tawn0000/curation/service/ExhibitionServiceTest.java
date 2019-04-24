package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("io.github.tawn0000.curation")
public class ExhibitionServiceTest {
    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Test
    public void testQueryExhibitionByAddress()
    {
        System.out.println(2222);
        List<ExhibitionToken> exhibitionTokenList = exhibitionService.queryExhibitionByAddress("桃园");
        for(ExhibitionToken x : exhibitionTokenList)
            System.out.println(x.geteName());
    }
    @Test
    //public List<Exhibition> queryExhibition()
    public void testQueryExhibition()
    {
        List<Exhibition> exhibitionList = exhibitionService.queryExhibition();
        for(Exhibition x : exhibitionList)
            System.out.println(x.geteName());
    }
}