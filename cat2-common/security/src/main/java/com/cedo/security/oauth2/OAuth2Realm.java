package com.cedo.security.oauth2;

import com.cedo.cat2auth.model.User;
import com.cedo.common.exception.RestException;
import com.cedo.security.vo.UserToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @Author chendong
 * @date 19-2-28 下午4:02
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private AbstractUserPermissionService userPermissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(接口保护，验证接口调用权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        Long userId = user.getId();

        // 用户权限列表
        Set<String> permission = userPermissionService.findPermissionById(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permission);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        UserToken userToken = userPermissionService.findUserByToken(token);
        if (userToken==null || userToken.getExpireTime().getTime()<System.currentTimeMillis()) {
            // token 已经失效
            throw new AuthenticationException("token失效，请重新登录");
        }

        long intervalTime = System.currentTimeMillis() - userToken.getExpireTime().getTime();
        if( intervalTime > 1800000){
            userToken.setExpireTime(new Date(userToken.getExpireTime().getTime() + intervalTime));
            userPermissionService.saveOrUpdate(userToken);
        }
        // 查询用户信息
        User user = userPermissionService.findUserById(userToken.getUserId());

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, getName());

        return info;
    }


}
