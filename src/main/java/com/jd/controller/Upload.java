package com.jd.controller;

import com.jd.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by lushun on 2017/3/24.
 */

@Controller
public class Upload {

    @Resource
    UploadService uploadService;

    @RequestMapping("/headUpload")
    @ResponseBody
    private String headUpload(@RequestParam("uid") String uid,@RequestParam("img") String img){
        String result =uploadService.headUpload(uid,img);
        return result;
    }

    @RequestMapping("/imgUpload")
    @ResponseBody
    private String imgUpload(HttpServletRequest request){
        String result = uploadService.imgUpload(request);
        return result;
    }
}
