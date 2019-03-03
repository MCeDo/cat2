package com.cedo.security.oauth2;


import com.cedo.cat2auth.model.User;
import com.cedo.redis.RedisKeys;
import com.cedo.redis.RedisUtil;
import com.cedo.security.vo.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author chendong
 * @date 19-2-28 下午4:51
 */
//@Service
public abstract class AbstractUserPermissionService {

    @Autowired
    private RedisUtil redisUtil;

    public UserToken findUserByToken(String token)  {
        String key = RedisKeys.getUserByToken(token);
        return redisUtil.get(key, UserToken.class);
    }

    public void saveOrUpdate(UserToken userToken) {
        redisUtil.set(RedisKeys.getUserByToken(userToken.getToken()), userToken);
    }

    public abstract User findUserById(Long userId);

    public Set<String> findPermissionById(Long userId) {
        return redisUtil.get(RedisKeys.getPermissionByUserId(userId), Set.class);
    }
}
