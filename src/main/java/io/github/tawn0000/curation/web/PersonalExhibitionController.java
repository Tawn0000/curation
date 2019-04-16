package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.service.UEService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.github.tawn0000.curation.utils.Responsetil;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/personalExhibition")
public class PersonalExhibitionController {

    @Autowired
    private UEService ueService;

    @Autowired
    private ExhibitionService exhibitionService;

    @ApiOperation(value = "获取收藏信息")
    @ApiImplicitParam(name="id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/collect")
    @ResponseBody
    public List<Exhibition> collect(Long id)
    {
        List<Long> eids = ueService.findByid(id);
        List<Exhibition> exhibitions = new ArrayList<>();
        for(Long eid : eids){
            Exhibition exhibition = exhibitionService.findbyid(eid);
            exhibitions.add(exhibition);
        }
        return exhibitions;
    }

    @ApiOperation(value = "获取历史足迹信息")
    @ApiImplicitParam(name = "id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/history")
    @ResponseBody
    public List<Exhibition> history(Long id)
    {
        List<Long> eids = ueService.findByid(id);
        List<Exhibition> exhibitions = new ArrayList<>();
        for(Long eid : eids){
            Exhibition exhibition = exhibitionService.findbyid(eid);
            exhibitions.add(exhibition);
        }
        return exhibitions;
    }

    @ApiOperation(value = "获取用户的体验")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @GetMapping("/experience")
    public Object experience(Long id){
        Map<Object, Object> result = new HashMap<>();
        List<Long> eidsexperirnce = ueService.findexperiencebyid(id, 1);
        List<Exhibition> experienceExhibitions = new ArrayList<>();
        for(Long eid : eidsexperirnce){
            Exhibition exhibition = exhibitionService.findbyid(eid);
            experienceExhibitions.add(exhibition);
        }
        result.put("Experience",experienceExhibitions);

        List<Long> eidsNoexperirnce = ueService.findexperiencebyid(id, 3);
        List<Exhibition> experienceNoExhibitions = new ArrayList<>();
        for(Long eid : eidsNoexperirnce){
            Exhibition exhibition = exhibitionService.findbyid(eid);
            experienceNoExhibitions.add(exhibition);
        }
        result.put("NoExperience",experienceNoExhibitions);

        return Responsetil.ok(result);
    }
}
