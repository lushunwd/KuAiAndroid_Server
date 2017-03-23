package com.jd.controller;

import com.jd.service.AdvService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class AdvertisementController {

    @Resource
    AdvService advService;

    @RequestMapping(value = "/adv",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String adv(){
      String result =advService.getAdvInfo();
      return result;
    }
}
