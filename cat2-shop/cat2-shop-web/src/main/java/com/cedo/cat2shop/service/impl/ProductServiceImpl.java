package com.cedo.cat2shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cedo.cat2shop.dao.ProductDao;
import com.cedo.cat2shop.model.Cate;
import com.cedo.cat2shop.model.Product;
import com.cedo.cat2shop.service.CateService;
import com.cedo.cat2shop.service.ProductService;
import com.cedo.cat2shop.util.PageUtil;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-19 下午11:56
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CateService cateService;

    @Override
    public HttpResult list(Map<String, Object> params) {
        IPage page = PageUtil.getPage(params);
//        Wrapper<Product> wrapper = new QueryWrapper<>();
//        productDao.selectPage(page, wrapper);
        productDao.selectPageWithImages(page, params);
        return HttpResult.ok(page);
    }

    @Override
    public HttpResult findById(Long id) {
        return HttpResult.ok(productDao.selectById(id));
    }

    @Override
    public HttpResult add(Product product) {
        String cate = cateService.findCateNameById(product.getCateId());
        product.setCate(cate);
        return productDao.insert(product)>0
                ?HttpResult.ok("添加成功")
                :HttpResult.error("添加失败");
    }

    @Override
    public HttpResult update(Product product) {
        String cate = cateService.findCateNameById(product.getCateId());
        product.setCate(cate);
        return productDao.updateById(product)>0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }

    @Override
    public HttpResult delete(Long id) {
        return productDao.deleteById(id) > 0
                ?HttpResult.ok("删除成功")
                :HttpResult.error("删除失败");
    }
}
