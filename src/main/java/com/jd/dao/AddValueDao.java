package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by lushun on 2017/3/24.
 */

@Repository
public interface AddValueDao {
    int addValue(Map<String,Object> value);
}
