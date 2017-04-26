package com.jd.controller;

import com.jd.service.CodeService;
import com.jd.service.SourceGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class codeController {

    @Resource
    CodeService codeService;


    @RequestMapping(value = "/code",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String sourceGroup(@RequestParam("mstart") int start,@RequestParam("type") String type){
        String codeInfo=codeService.getCodeInfo(start,type);
        return codeInfo;
    }
}
