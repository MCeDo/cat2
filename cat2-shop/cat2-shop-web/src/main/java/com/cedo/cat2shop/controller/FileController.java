package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.service.FileService;
import com.cedo.common.http.HttpResult;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件传输
 * @Author chendong
 * @date 19-3-20 下午2:41
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    private String host = "http://localhost:8088/shop";

    @PostMapping("/image")
    public HttpResult upload(MultipartFile file) {
        String url = fileService.uploadPhoto(file);
        return HttpResult.ok("图片路径",host+url);
    }
}