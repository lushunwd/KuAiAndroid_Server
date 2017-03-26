package com.jd.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by lushun on 2017/3/23.
 */

@Repository
public interface ThumbDao {
    int up(String qid);
    int down(String qid);
}
