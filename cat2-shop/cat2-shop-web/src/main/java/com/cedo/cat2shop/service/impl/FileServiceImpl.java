package com.cedo.cat2shop.service.impl;

import com.cedo.cat2shop.service.FileService;
import com.cedo.common.util.MathUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author chendong
 * @date 19-3-20 下午3:04
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${com.cedo.dir}")
    private String dir;

    @Value("${com.cedo.images.location}")
    private String path;

    @Override
    public String uploadPhoto(@RequestParam("file") MultipartFile file) {
        String prefix = file.getContentType().substring(file.getContentType().lastIndexOf("/")).replace("/", ".");
        String fileName = MathUtil.UUID()+prefix;

        try {
            File dest = new File(dir+path+fileName);
            //判断文件父目录是否存在
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            file.transferTo(dest);
            return path+fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
