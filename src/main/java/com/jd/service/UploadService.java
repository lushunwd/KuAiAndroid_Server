package com.jd.service;

import com.jd.dao.UploadDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Created by lushun on 2017/3/24.
 */

@Service
public class UploadService {

    @Resource
    UploadDao uploadDao;

    public String headUpload(String uid, String img) {

        int flag = 0;
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = dateFormat.format(now);
        uploadDao.updateHead(uid, fileName+".png");
        byte[] bytes = Base64.decode(img);
        String rootPath = getClass().getClassLoader().getResource("/").getPath();
        File root = new File(rootPath);
        //获取文件上传需要保存的路径
        String path = root.getParentFile().getParentFile().getPath() + File.separator + "static" + File.separator + "userImg"+File.separator+fileName+".png";
        File file = new File(path);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            fos.write(bytes);
        } catch (IOException e) {
            flag = 1;
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                flag = 1;
                e.printStackTrace();
            }
        }
        if (flag == 1) {
            return "no";
        } else {
            return "ok";
        }
    }

    public String imgUpload(HttpServletRequest request) {
        int flag = 0;
        //获得磁盘文件条目工厂。
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String rootPath = getClass().getClassLoader().getResource("/").getPath();
        File root = new File(rootPath);
        //获取文件上传需要保存的路径
        String path = root.getParentFile().getParentFile().getPath() + File.separator + "static" + File.separator + "valueImg";

        //设置暂时存放文件的存储室，这个存储室可以和最终存储文件的文件夹不同。因为当文件很大的话会占用过多内存所以设置存储室。
        factory.setRepository(new File(path));

        //设置缓存的大小，当上传文件的容量超过缓存时，就放到暂时存储室。
        factory.setSizeThreshold(1024 * 1024);
        //上传处理工具类
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            //调用 parseRequest（request）方法  获得上传文件 FileItem 的集合list 可实现多文件上传。
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //获取表单属性名字。
                String name = item.getFieldName();
                //如果获取的表单信息是普通的文本信息。即通过页面表单形式传递来的字符串。
                if (item.isFormField()) {
                    //获取用户具体输入的字符串，
                    String value = item.getString();
                    request.setAttribute(name, value);
                }
                //如果传入的是非简单字符串，而是图片，音频，视频等二进制文件。
                else {
                    //获取路径名
                    String value = item.getName();
                    //取到最后一个反斜杠。
                    int start = value.lastIndexOf("\\");
                    //截取上传文件的 字符串名字。+1是去掉反斜杠。
                    String filename = value.substring(start + 1);
                    request.setAttribute(name, filename);

                    /*第三方提供的方法直接写到文件中。
                     * item.write(new File(path,filename));*/
                    //收到写到接收的文件中。
                    OutputStream out = new FileOutputStream(new File(path, filename));
                    InputStream in = item.getInputStream();

                    int length = 0;
                    byte[] buf = new byte[1024];
                    System.out.println("获取文件总量的容量:" + item.getSize());

                    while ((length = in.read(buf)) != -1) {
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                }
            }

        } catch (Exception e) {
            flag = 1;
            e.printStackTrace();
        }

        if (flag == 1) {
            return "no";
        } else {
            return "ok";
        }
    }


//        int flag = 0;
//        String fileName = request.getParameter("fileName");
//        String rootPath = getClass().getClassLoader().getResource("/").getPath();
//        File root = new File(rootPath);
//        String filePath = root.getParentFile().getParentFile().getPath()+ File.separator + "static" + File.separator +"valueImg"+File.separator+ fileName;
//
//
//        File file= new File(filePath);
//
//        InputStream stream = null;
//        FileOutputStream fos = null;
//
//        try {
//            stream =request.getInputStream();
//            fos = new FileOutputStream(file);
//            int bytesRead = 0;
//            byte[] buffer = new byte[1024];
//            while ((bytesRead = stream.read(buffer, 0, 1024)) != -1) {
//                fos.write(buffer, 0, bytesRead);//将文件写入服务器的硬盘上
//            }
//        } catch (IOException e) {
//            flag = 1;
//            e.printStackTrace();
//        } finally {
//            try {
//                stream.close();
//                fos.close();
//            } catch (IOException e) {
//                flag = 1;
//                e.printStackTrace();
//            }
//        }


}
