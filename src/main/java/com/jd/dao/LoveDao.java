package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface LoveDao {
    List<Map<String,Object>> getLoveList(int offset, int pageSize);
    int getCount();
}
