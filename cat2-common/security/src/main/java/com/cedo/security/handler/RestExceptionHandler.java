package com.cedo.security.handler;

import com.cedo.common.exception.RestException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * @Author chendong
 * @date 19-3-1 下午4:21
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * 自定义异常拦截处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler({RestException.class})
    @ResponseBody
    public Map<String,Object> exceptionHandler(HttpServletRequest request, HttpServletResponse response, RestException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", e.getCode());
        result.put("msg", e.getMsg());
        result.put("timestamp", new Timestamp(System.currentTimeMillis()));
        result.put("path", request.getRequestURI());
        response.setStatus(e.getCode());
        return result;
    }

    /**
     * shiro 权限不足异常拦截处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Map<String,Object> unAuthenticationException(HttpServletRequest request, HttpServletResponse response, UnauthorizedException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.FORBIDDEN.value());
        result.put("msg", HttpStatus.FORBIDDEN.getReasonPhrase());
        result.put("timestamp", new Timestamp(System.currentTimeMillis()));
        result.put("path", request.getRequestURI());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return result;
    }

    /**
     * shiro token失效异常拦截处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Map<String,Object> authenticationException(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.FORBIDDEN.value());
        result.put("msg", HttpStatus.FORBIDDEN.getReasonPhrase());
        result.put("timestamp", new Timestamp(System.currentTimeMillis()));
        result.put("path", request.getRequestURI());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return result;
    }
}
