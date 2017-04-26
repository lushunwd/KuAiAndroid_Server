package com.jd.service;

import com.jd.dao.AddValueDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */


@Service
public class AddValueService {
    @Resource
    AddValueDao addValueDao;

    public String addValue(Map<String,Object> value) {

        int result = addValueDao.addValue(value);

        if (result!=0){
            return "ok";
        }else {
            return "no";
        }

    }
}
