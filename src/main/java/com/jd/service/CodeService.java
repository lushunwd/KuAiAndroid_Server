package com.jd.service;

import com.jd.dao.CodeDao;
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
public class CodeService {
    @Resource
    CodeDao codeDao;


    public String getCodeInfo(int start, String type) {
        int pageSize = 10;
        int offset = (start - 1) * pageSize;
        List<Map<String, Object>> codeList = codeDao.getCodeList(offset, pageSize, type);
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray codeListInfo = JSONArray.fromObject(codeList, config);
        return codeListInfo.toString();
    }
}
