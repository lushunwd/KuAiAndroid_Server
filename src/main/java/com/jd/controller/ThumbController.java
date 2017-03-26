package com.jd.controller;

import com.jd.service.ThumbUpService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lushun on 2017/3/24.
 */


@Controller
public class ThumbController {

    @Resource
    ThumbUpService thumbUpService;


    @RequestMapping(value = "/thumb",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String ThumbUpOrDown(@RequestParam("value") String value){
        JSONObject jsonObject = JSONObject.fromObject(value);
        Map<String, Object> map = (Map)jsonObject;
         String thumbiInfo =thumbUpService.getThumbInfo(map);
        return thumbiInfo;
    }
}
