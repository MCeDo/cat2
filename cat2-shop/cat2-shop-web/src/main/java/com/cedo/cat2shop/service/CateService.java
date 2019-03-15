package com.cedo.cat2shop.service;

import com.cedo.cat2shop.model.Cate;
import com.cedo.common.http.HttpResult;

/**
 * @Author chendong
 * @date 19-3-13 下午7:01
 */
public interface CateService {
    
    HttpResult list(Integer current, Integer size);

    HttpResult findById(Long id);

    HttpResult add(Cate cate);

    HttpResult update(Cate cate);
}
