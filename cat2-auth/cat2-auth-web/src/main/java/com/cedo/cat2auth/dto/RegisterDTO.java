package com.cedo.cat2auth.dto;

import lombok.Data;

/**
 * 注册数据传输类
 * @Author chendong
 * @date 19-3-3 上午11:15
 */
@Data
public class RegisterDTO {

    private String account;
    private String username;
    private String password;
    private String captcha;

}
