package com.jd.service;

import com.jd.dao.RegisterDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */


@Service
public class RegisterService {
    @Resource
    RegisterDao registerDao;

    public String register (Map<String,Object> user){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        user.put("utime",dateFormat.format( now ));
        List userInfoByName=registerDao.getUserInfoByName(user);

        int row;
        if (userInfoByName.isEmpty()){
            row=registerDao.addUser(user);
            if (row!=0){
                return "ok";
            }else {
                return "fail";
            }
        }else {
            return "no";
        }
    }
}
