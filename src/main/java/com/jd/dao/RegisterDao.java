package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface RegisterDao {
    List<Map<String,Object>> getUserInfoByName(Map<String,Object> user);
    int addUser(Map<String,Object> user);
}
