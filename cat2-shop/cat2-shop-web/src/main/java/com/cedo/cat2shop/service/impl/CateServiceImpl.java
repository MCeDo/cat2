package com.cedo.cat2shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.cat2shop.dao.CateDao;
import com.cedo.cat2shop.model.Cate;
import com.cedo.cat2shop.service.CateService;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chendong
 * @date 19-3-13 下午7:33
 */
@Service
public class CateServiceImpl implements CateService {

    @Autowired
    private CateDao cateDao;

    @Override
    public HttpResult list(Integer current, Integer size) {
        IPage<Cate> page = new Page<>(current, size);
        Wrapper<Cate> wrapper = new QueryWrapper<>();
        cateDao.selectPage(page, wrapper);
        return HttpResult.ok(page);
    }

    @Override
    public HttpResult findById(Long id) {
        return HttpResult.ok(cateDao.selectById(id));
    }

    @Override
    public HttpResult add(Cate cate) {
        return cateDao.insert(cate)>0
                ?HttpResult.ok("添加成功")
                :HttpResult.error("添加失败");
    }

    @Override
    public HttpResult update(Cate cate) {
        return cateDao.updateById(cate)>0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }
}
