package com.cedo.security.oauth2;

import com.alibaba.fastjson.JSONObject;
import com.cedo.common.http.HttpResult;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Oauth2过滤器
 * @Author chendong
 * @date 19-2-28 下午2:17
 */
public class OAuth2Filter extends AuthenticatingFilter {

    public static final String TOKEN = "token";

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return new OAuth2Token(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if(StringUtils.isBlank(token)) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpResult result = HttpResult.error(HttpStatus.UNAUTHORIZED, "invalid token");
            String json = JSONObject.toJSONString(result);
            response.getWriter().print(json);
            return false;
        }
        return executeLogin(servletRequest, servletResponse);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json; charset=utf-8");
        try {
            // 处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            HttpResult result = HttpResult.error(HttpStatus.UNAUTHORIZED, throwable.getMessage());
            String json = JSONObject.toJSONString(result);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
        }
        return false;
    }

    private String getRequestToken(HttpServletRequest request){
        String token = request.getHeader(TOKEN);
        //如果头部中不存在token，从参数中取
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN);
        }
        return token;
    }
}
