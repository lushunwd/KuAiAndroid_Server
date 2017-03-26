package com.jd.controller;

import com.jd.service.AdvzbService;
import com.jd.service.GaofangService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class GaofangController {

    @Resource
    GaofangService gaofangService;

    @RequestMapping(value = "/gaofang",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String gaofang(@RequestParam("mstart") int start){
        String gaofangInfo=gaofangService.getGaofangInfo(start);
        return gaofangInfo;
    }
}
