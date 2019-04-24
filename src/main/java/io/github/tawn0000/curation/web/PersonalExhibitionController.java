package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.entity.UE;
import io.github.tawn0000.curation.service.ExhibitionService;
import io.github.tawn0000.curation.service.UEService;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import io.github.tawn0000.curation.service.impl.UEServiceImpl;
import io.github.tawn0000.curation.utils.Responsetil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Api(value = "个人中心展览信息",tags = "PersonalExhibition")
@RestController
@RequestMapping("/personal")
public class PersonalExhibitionController {

    @Autowired
    @Qualifier("UEServiceImpl")
    private UEServiceImpl ueService;

    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Value("/tmp/curation/exhibition")
    private String exhibitionPath;

    @ApiOperation(value = "获取收藏信息")
    @ApiImplicitParam(name="id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/collect")
    @ResponseBody
    public List<ExhibitionToken>  collect(Long id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
       // System.out.println("**");
        List<Long> eidList = ueService.queryExhibitionByUid(id);
        List<ExhibitionToken> exhibitionTokens = new ArrayList<>();
        for(Long eid : eidList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            exhibitionTokens.add(exhibitionToken);
        }
        //System.out.println(exhibitionTokens.size());
       map.put("exhibition",exhibitionTokens);
       return exhibitionTokens;
    }

    @ApiOperation(value = "获取历史足迹信息")
    @ApiImplicitParam(name = "id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/history")
    @ResponseBody
    public List<ExhibitionToken> history(Long id)
    {
        //System.out.println("IIIII");
        List<UE> ueList = ueService.queryUEByUid(id);
       //System.out.println(ueList.size());
        List<ExhibitionToken> exhibitionTokens = new ArrayList<>();
        for(UE ue : ueList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(ue.geteId()));
            exhibitionTokens.add(exhibitionToken);
        }
        return exhibitionTokens;
    }

    @ApiOperation(value = "获取用户的体验")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @GetMapping("/experience")
    public Object experience(Long id){
        //已体验
        Map<Object, Object> result = new HashMap<>();
        List<Long> experiencedList = ueService.queryUEByUeStatus(id, 3);
        List<ExhibitionToken> experienceExhibitions = new ArrayList<>();
        for(Long eid : experiencedList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            experienceExhibitions.add(exhibitionToken);
        }
        result.put("Experienced",experienceExhibitions);

        //已报名
        List<Long> noExperiencedList = ueService.queryUEByUeStatus(id, 1);
        List<ExhibitionToken> experienceNoExhibitions = new ArrayList<>();
        for(Long eid : noExperiencedList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            experienceNoExhibitions.add(exhibitionToken);
        }
        result.put("NoExperienced",experienceNoExhibitions);

        return Responsetil.ok(result);
    }

    @ApiOperation(value= "已参观展览的详细信息")
    @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long")
    @GetMapping("/detail")
    public Exhibition detail (Long eid){
        Exhibition exhibition = exhibitionService.queryExhibitionById(eid);
        return exhibition;
    }
}
