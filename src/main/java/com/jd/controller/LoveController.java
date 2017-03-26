package com.jd.controller;

import com.jd.service.LoveService;
import com.jd.service.SmallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class LoveController {

    @Resource
    LoveService loveService;

    @RequestMapping(value = "/love",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String love(@RequestParam("mstart") int start){
        String loveInfo=loveService.getLoveInfo(start);
        return loveInfo;
    }
}
