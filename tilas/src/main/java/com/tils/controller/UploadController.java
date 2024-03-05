package com.tils.controller;

import com.tils.pojo.Result;
import com.tils.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) {
        log.info("上传文件");
        String url = null;
        try {
            url = aliOSSUtils.upload(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("url->"+url);
        return Result.success(url);
    }
}
