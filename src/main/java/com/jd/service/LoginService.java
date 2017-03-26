package com.jd.service;

import com.jd.dao.LoginDao;
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
public class LoginService {
    @Resource
    LoginDao loginDao;

    public String getUserInfo(Map<String, Object> user) {
        List<Map<String, Object>>userInfoListByName = loginDao.getUserInfoByName(user);
        List<Map<String, Object>>userInfoList = loginDao.getUserInfo(user);
        if(userInfoListByName.isEmpty()){
            return "nouser";
        }else if(userInfoList.isEmpty()) {
            return "nopass";
        }else {
            JsonConfig config=new JsonConfig();
            config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
            JSONArray userInfo = JSONArray.fromObject(userInfoList,config);
            return userInfo.toString();
        }

    }
}
