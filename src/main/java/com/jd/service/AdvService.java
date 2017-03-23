package com.jd.service;

import com.jd.dao.AdvDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        JSONArray advInfo = JSONArray.fromObject(advList);
        return advInfo.toString();
    }
}
