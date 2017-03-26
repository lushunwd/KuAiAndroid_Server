package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface HServerDao {
    List<Map<String,Object>> getHServerList(int offset, int pageSize);
    int getCount();
}
