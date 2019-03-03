package com.cedo.redis;

/**
 * @Author chendong
 * @date 19-2-28 下午5:04
 */
public class RedisKeys {

    public static final String KEY_USER = "user";
    public static final String KEY_TOKEN = "token";

    public static String getUserByToken(String token) {
        return KEY_USER+":token:"+token;
    }

    public static String getUserById(Long id) {
        return KEY_USER+":id:"+id;
    }

    public static String getTokenByUserId(long userId) {
        return KEY_TOKEN+":userId:"+userId;
    }

    public static String getPermissionByUserId(Long userId) {
        return KEY_USER+":permission:"+userId;
    }
}
