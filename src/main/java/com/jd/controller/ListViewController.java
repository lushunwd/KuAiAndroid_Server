package com.jd.controller;

import com.jd.dao.ListViewDao;
import com.jd.service.ListViewService;
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
public class ListViewController {

    @Resource
    ListViewService listViewService;

    @RequestMapping(value = "/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String list(@RequestParam("mstart") int start){
        String listViewInfo=listViewService.getListViewInfo(start);
        return listViewInfo;
    }
}
