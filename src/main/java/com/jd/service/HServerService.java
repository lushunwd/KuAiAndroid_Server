package com.jd.service;

import com.jd.dao.HServerDao;
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
public class HServerService {
    @Resource
    HServerDao HServerDao;

    public String getHServerInfo(int start) {
        int pageSize=10;
        int offset=(start-1)*pageSize;
        List<Map<String, Object>> hserverList = HServerDao.getHServerList(offset,pageSize);
        JsonConfig config=new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray hserverInfo =JSONArray.fromObject(hserverList,config);
        return hserverInfo.toString();
    }
}
