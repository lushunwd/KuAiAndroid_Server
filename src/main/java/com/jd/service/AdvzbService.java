package com.jd.service;

import com.jd.dao.AdvzbDao;
import com.jd.dao.LoveDao;
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
public class AdvzbService {
    @Resource
    AdvzbDao advzbDao;

    public String getAdbzbInfo(int start) {
        int pageSize=10;
        int offset=(start-1)*pageSize;
        List<Map<String, Object>> advzbList = advzbDao.getAdvzbList(offset,pageSize);
        JsonConfig config=new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray advzbInfo =JSONArray.fromObject(advzbList,config);
        return advzbInfo.toString();
    }
}
