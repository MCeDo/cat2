package com.cedo.cat2shop.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.cat2shop.dao.BaseDao;
import com.cedo.common.http.HttpResult;
import com.cedo.common.validator.AddGroup;
import com.cedo.common.validator.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chendong
 * @date 19-3-13 下午8:53
 */
public class BaseController<T> {

    @Autowired
    private BaseDao baseDao;

    @GetMapping
    public HttpResult list(@RequestParam(defaultValue = "0")Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        Wrapper<T> wrapper = new QueryWrapper<>();
        IPage<T> pageList = new Page<>(page, limit);
        baseDao.selectPage(pageList, wrapper);
        return HttpResult.ok(pageList);
    }

    @GetMapping("{id}")
    public HttpResult get(@PathVariable Long id) {
        return HttpResult.ok(baseDao.selectById(id));
    }

    @PostMapping
    public HttpResult add(@RequestBody @Validated(AddGroup.class) T t) {
        return baseDao.insert(t) > 0
                ?HttpResult.ok("添加成功")
                :HttpResult.error("添加失败");
    }

    @PutMapping
    public HttpResult update(@RequestBody @Validated(UpdateGroup.class) T t) {
        return baseDao.updateById(t) > 0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }
}
