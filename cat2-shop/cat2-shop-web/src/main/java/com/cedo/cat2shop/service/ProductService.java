package com.cedo.cat2shop.service;

import com.cedo.cat2shop.model.Order;
import com.cedo.cat2shop.model.Product;
import com.cedo.common.http.HttpResult;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-19 下午11:56
 */
public interface ProductService {
    HttpResult list(Map<String, Object> params);

    HttpResult findById(Long id);

    HttpResult add(Product product);

    HttpResult update(Product product);

    HttpResult delete(Long id);
}
