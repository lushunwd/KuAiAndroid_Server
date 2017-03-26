package com.jd.controller;

import com.jd.service.AddValueService;
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
public class AddValueController {

    @Resource
    AddValueService addValueService;

    @RequestMapping(value = "/addValue",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String source(@RequestParam("value") String value){

        JSONObject jsonObject = JSONObject.fromObject(value);
        Map<String,Object> map= (Map<String, Object>) jsonObject;
        String addValueInfo=addValueService.addValue(map);
        return addValueInfo;
    }
}
