package com.cedo.cat2auth.client.service;

import com.cedo.cat2auth.client.dao.UserMapper;
import com.cedo.cat2auth.model.User;
import com.cedo.redis.RedisKeys;
import com.cedo.redis.RedisUtil;
import com.cedo.security.oauth2.AbstractUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chendong
 * @date 19-3-2 下午6:44
 */
@Service
public class UserPermission extends AbstractUserPermissionService {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User findUserById(Long userId)  {
//        return userMapper.selectById(userId);
        return redisUtil.get(RedisKeys.getUserById(userId), User.class);
    }
}
