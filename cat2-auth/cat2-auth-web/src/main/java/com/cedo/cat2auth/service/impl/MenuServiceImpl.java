package com.cedo.cat2auth.service.impl;

import com.cedo.cat2auth.dao.MenuMapper;
import com.cedo.cat2auth.model.Menu;
import com.cedo.cat2auth.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chendong
 * @date 19-3-2 下午9:07
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuByUserId(long userId) {
        return menuMapper.findMenuByUserId(userId);
    }

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }
}
