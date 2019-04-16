package io.github.tawn0000.curation.web;

import io.github.tawn0000.curation.entity.User;
import io.github.tawn0000.curation.service.UserService;
import io.github.tawn0000.curation.utils.HttpRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/auth")
@Validated
public class WxAuthController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map decodeUserInfo(String code) {

        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "***********************";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "************************";
        //授权（必填）
        String grant_type = "***************************";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        User user = userService.getUserByopenId(openid);
        if(user == null) userService.addUser(new User(openid));
        user = userService.getUserByopenId(openid);
        map.put("uId",user.getuId());
        return map;
    }
}

