package com.cedo.cat2auth.service.impl;

import com.cedo.cat2auth.service.UserTokenService;
import com.cedo.common.util.TokenGenerator;
import com.cedo.redis.RedisKeys;
import com.cedo.redis.RedisUtil;
import com.cedo.security.vo.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author chendong
 * @date 19-3-1 下午1:07
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserToken createToken(long userId) {
        String token = TokenGenerator.generateToken();
        Date now = new Date();
        Date expireTime = new Date(now.getTime()+EXPIRE*1000);
        //判断是否生成过token
        UserToken userToken = fingTokenByUserId(userId);
        if(userToken == null) {
            userToken = new UserToken(userId, token, expireTime, now);
        }else {
            userToken.setToken(token);
            userToken.setExpireTime(expireTime);
            userToken.setLastUpdateTime(now);
        }
        //更新redis缓存
        save(userToken);
        return userToken;
    }

    @Override
    public UserToken fingTokenByUserId(long userId) {
        return redisUtil.get(RedisKeys.getTokenByUserId(userId), UserToken.class);
    }

    @Override
    public boolean save(UserToken userToken) {
        String tokenKey = RedisKeys.getTokenByUserId(userToken.getUserId());
        String userKey = RedisKeys.getUserByToken(userToken.getToken());
        long expire = (userToken.getExpireTime().getTime()-userToken.getLastUpdateTime().getTime())/1000;
        //设置token对应的用户登录状态
        redisUtil.set(userKey, userToken, expire);
        //设置userId对应的token
        return redisUtil.set(tokenKey, userToken, expire);
    }
}
