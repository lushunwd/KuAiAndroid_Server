package com.jd.service;

import com.jd.dao.SourceDao;
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
public class SourceService {
    @Resource
    SourceDao sourceDao;

    public String getSourceInfo(int start) {
        int pageSize=10;
        int offset=(start-1)*pageSize;
        List<Map<String, Object>> sourceList = sourceDao.getSourceList(offset,pageSize);
        JsonConfig config=new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray sourceInfo =JSONArray.fromObject(sourceList,config);
        return sourceInfo.toString();
    }
}
