package com.jd.service;

import com.jd.dao.AddValueDao;
import com.jd.dao.SourceDao;
import com.jd.util.DateJsonValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;
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
