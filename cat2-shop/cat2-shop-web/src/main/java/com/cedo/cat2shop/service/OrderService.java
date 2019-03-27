package com.cedo.cat2shop.service;

import com.cedo.cat2shop.model.Order;
import com.cedo.common.http.HttpResult;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-19 下午11:36
 */
public interface OrderService {
    HttpResult list(Map<String, Object> params);

    HttpResult findById(Long id);

    HttpResult add(Order order);

    HttpResult update(Order order);

    HttpResult delete(Long id);
}
