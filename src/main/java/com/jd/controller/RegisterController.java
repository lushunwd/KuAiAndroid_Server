package com.jd.controller;


import com.jd.service.RegisterService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Controller
public class RegisterController {

    @Resource
    RegisterService registerService;

    @RequestMapping("/register")
    @ResponseBody
    private String register(@RequestParam("value") String json){
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String,Object> map= (Map<String, Object>) jsonObject;
        String result= registerService.register(map);
        return result;
    }
}
