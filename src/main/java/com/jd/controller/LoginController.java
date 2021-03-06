package com.jd.controller;

import com.jd.service.LoginService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String login(@RequestParam("value") String json){
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> map = (Map)jsonObject;
        String userInfo=loginService.getUserInfo(map);
        return userInfo;
    }
}
