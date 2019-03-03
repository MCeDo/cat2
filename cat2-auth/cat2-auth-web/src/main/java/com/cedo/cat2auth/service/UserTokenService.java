package com.cedo.cat2auth.service;

import com.cedo.security.vo.UserToken;

/**
 * @Author chendong
 * @date 19-3-1 下午1:06
 */
public interface UserTokenService {

    UserToken createToken(long userId);

    UserToken fingTokenByUserId(long userId);

    boolean save(UserToken userToken);
}
