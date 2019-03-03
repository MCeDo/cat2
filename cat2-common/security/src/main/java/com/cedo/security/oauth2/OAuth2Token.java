package com.cedo.security.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义token对象
 * @Author chendong
 * @date 19-2-28 下午2:23
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
