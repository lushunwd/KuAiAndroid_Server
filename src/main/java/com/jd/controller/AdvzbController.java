package com.jd.controller;

import com.jd.service.AdvzbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class AdvzbController {

    @Resource
    AdvzbService advzbService;

    @RequestMapping(value = "/advzb",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String advzb(@RequestParam("mstart") int start){
        String advzbInfo=advzbService.getAdbzbInfo(start);
        return advzbInfo;
    }
}
