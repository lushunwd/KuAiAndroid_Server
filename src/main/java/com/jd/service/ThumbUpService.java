package com.jd.service;

import com.jd.dao.ThumbDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */


@Service
public class ThumbUpService {
    @Resource
    ThumbDao thumbDao;

    public String getThumbInfo(Map<String,Object> map) {

        int result=0;

        if(map.get("tag").equals("1")){
            result=thumbDao.up(map.get("qid").toString());
        }else if(map.get("tag").equals("0")){
            result=thumbDao.down(map.get("qid").toString());
        }
        if (result!=0){
            return "ok";
        }else {
            return "no";
        }
    }
}
