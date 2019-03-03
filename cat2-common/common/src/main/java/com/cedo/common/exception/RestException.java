package com.cedo.common.exception;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 统一异常
 * @Author chendong
 * @date 19-2-28 下午9:22
 */
@Data
public class RestException extends RuntimeException{

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    private Timestamp timestamp;

    private String path;

    public RestException() {}

    public RestException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
