package com.cedo.cat2auth.service;

import com.cedo.cat2auth.dto.LoginDTO;
import com.cedo.cat2auth.model.User;
import com.cedo.common.http.HttpResult;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-1 下午12:38
 */
public interface UserService {

    HttpResult login(LoginDTO loginDTO);

    HttpResult logout(String token);

    User findUserByUsername(String account);

    void findPermission(Long id);

    HttpResult register(User user);

    HttpResult findUserById(Long id);

    HttpResult add(User user);

    HttpResult update(User user);

    HttpResult list(Map<String, Object> params);

    HttpResult delete(Long id);
}
