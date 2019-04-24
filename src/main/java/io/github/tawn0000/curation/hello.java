package io.github.tawn0000.curation;


import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.service.ExhibitionService;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class hello {
    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void testQueryExhibitionByAddress()
    {
        List<ExhibitionToken> exhibitionTokenList = exhibitionService.queryExhibitionByAddress("江苏");
        for(ExhibitionToken x : exhibitionTokenList)
            System.out.println(x.geteName());
    }
}
