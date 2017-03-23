package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface SmallDao {
    List<Map<String,Object>> getSmallList(int offset,int pageSize);
    int getCount();
}
