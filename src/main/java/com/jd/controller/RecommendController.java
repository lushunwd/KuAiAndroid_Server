package com.jd.controller;

import com.jd.service.RecommendService;
import com.jd.service.SourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class RecommendController {

    @Resource
    RecommendService recommendService;

    @RequestMapping(value = "/recommend",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String recommend(@RequestParam("mstart") int start){
        String recommendInfo=recommendService.getRecommendInfo(start);
        return recommendInfo;
    }
}
