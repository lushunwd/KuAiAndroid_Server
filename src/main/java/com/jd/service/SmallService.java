package com.jd.service;

import com.jd.dao.SmallDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */


@Service
public class SmallService {
    @Resource
    SmallDao smallDao;

    public String getSmallInfo(int start) {
        int pageSize=10;
        int offset=(start-1)*pageSize;
        List<Map<String, Object>> smallList = smallDao.getSmallList(offset,pageSize);
        JSONArray smallInfo =JSONArray.fromObject(smallList);
        return smallInfo.toString();
    }
}
