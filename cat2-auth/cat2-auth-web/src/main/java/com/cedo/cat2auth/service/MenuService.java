package com.cedo.cat2auth.service;

import com.cedo.cat2auth.model.Menu;

import java.util.List;

/**
 * @Author chendong
 * @date 19-3-2 下午9:06
 */
public interface MenuService {

    /**
     * 根据用户ID查出用户对应角色的权限
     * @param userId
     * @return
     */
    List<Menu> findMenuByUserId(long userId);

    /**
     * 查出所有权限
     * @return
     */
    List<Menu> findAll();
}
