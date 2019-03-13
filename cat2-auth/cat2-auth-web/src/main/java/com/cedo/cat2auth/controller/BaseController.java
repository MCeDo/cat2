package com.cedo.cat2auth.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

/**
 * @Author chendong
 * @date 19-3-4 下午6:10
 */
public class BaseController <T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @GetMapping
    public HttpResult list() {
        IPage page = new Page();
        page.setPages(1);
        page.setSize(10);
        Wrapper<T> wrapper = new QueryWrapper<>();
        baseMapper.selectPage(page, wrapper);
        return null;
    }
}
