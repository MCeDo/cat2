package com.cedo.cat2shop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author chendong
 * @date 19-3-20 下午3:03
 */
public interface FileService {

    /**
     * 上传图片文件
     * @param file
     * @return 文件路径
     */
    public String uploadPhoto(MultipartFile file);
}
