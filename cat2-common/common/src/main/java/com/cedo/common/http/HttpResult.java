package com.cedo.common.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果封装
 * @Author chendong
 * @date 19-2-28 下午2:31
 */
@Data
public class HttpResult {

    private int code = 200;
    private String msg;
    private Object data;

    public HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpResult() {

    }

    public static HttpResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code, String msg) {
        return new HttpResult(code, msg);
    }

    public static HttpResult error(HttpStatus httpStatus, String msg) {
        return new HttpResult(httpStatus.value(), msg);
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public static HttpResult ok(String msg) {
        return new HttpResult(200,msg);
    }

    public static HttpResult ok(Object data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        return result;
    }

    public static HttpResult ok(String msg, Object data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult ok(String msg, Object data, Page page) {
        HttpResult result = new HttpResult();
        result.setMsg(msg);
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("page", page);
        result.setData(map);
        return result;
    }

}
