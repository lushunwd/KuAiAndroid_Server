package com.jd.controller;

import com.jd.service.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class ShareController {

    @Resource
    ShareService shareService;

    @RequestMapping(value = "/share",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String share(@RequestParam("mstart") int start){
        String shareInfo=shareService.getShareInfo(start);
        return shareInfo;
    }
}
