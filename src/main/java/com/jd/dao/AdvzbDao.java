package com.jd.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface AdvzbDao {
    List<Map<String,Object>> getAdvzbList(int offset, int pageSize);
}
