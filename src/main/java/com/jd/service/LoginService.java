package com.jd.service;

import com.jd.dao.LoginDao;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
            JSONArray userInfo = JSONArray.fromObject(userInfoList);
            return userInfo.toString();
        }

    }
}
