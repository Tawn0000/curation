package io.github.tawn0000.curation;


import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.service.ExhibitionService;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.io.File;
@RestController
public class hello {
    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Value("${curarion.user-image-path}")
    private String path;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void testQueryExhibitionByAddress()
    {
        String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath()+ "\\files";
        basePath = basePath.replaceAll("\\\\","/");
        File file =new File(basePath + path);
//如果文件夹不存在则创建
        System.out.println(basePath + path);
        if  (!file .exists()  && !file .isDirectory())
        {
            System.out.println("//不存在");
            file .mkdirs();
        } else
        {
            System.out.println("//目录存在");
        }
    }
}
