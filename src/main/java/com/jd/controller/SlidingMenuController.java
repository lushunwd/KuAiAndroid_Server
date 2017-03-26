package com.jd.controller;

import com.jd.service.LoveService;
import com.jd.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lushun on 2017/3/22.
 */

@Controller
public class SlidingMenuController {

    @Resource
    MenuService menuService;

    @RequestMapping(value = "/menu",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String menu(@RequestParam("mstart") int start){
        String menuInfo=menuService.getMenuInfo(start);
        return menuInfo;
    }
}
