package com.jd.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by lushun on 2017/3/24.
 */

@Repository
public interface UploadDao {
    int updateHead(String uid,String fileName);
}
