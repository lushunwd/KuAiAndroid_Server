package com.jd.service;

import com.jd.dao.ShareDao;
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
public class ShareService {
    @Resource
    ShareDao shareDao;

    public String getShareInfo(int start) {
        List<Map<String, Object>> shareList = shareDao.getShareList(start);
        JsonConfig config=new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray shareInfo =JSONArray.fromObject(shareList,config);
        return shareInfo.toString();
    }
}
