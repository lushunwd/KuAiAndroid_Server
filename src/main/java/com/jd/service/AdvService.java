package com.jd.service;

import com.jd.dao.AdvDao;
import com.jd.util.DateJsonValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */


@Service
public class AdvService {
    @Resource
    AdvDao advDao;

    public String getAdvInfo() {
     List<Map<String,Object>> advList= advDao.getAdvList();
        JsonConfig config=new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray advInfo = JSONArray.fromObject(advList,config);
        return advInfo.toString();
    }
}
