package com.springmvc4.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 章辉勇
 * @创建时间 2018年11月03日
 * @描述: 文件上传控制器
 **/
@Controller
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    /**
     * ① 使用MultipartFile file接受上传的文件。
     * */
    String upload(MultipartFile file) {
        try {
            /**
             * ② 使用FileUtils.writeByteArrayToFile快速写文件到磁盘。
             * */
            FileUtils.writeByteArrayToFile(new File("D:/code/test/file/" + file.getOriginalFilename()), file.getBytes());
            return "OK";
        } catch (IOException e) {
            e.printStackTrace();
            return "WRONG";
        }
    }

}
