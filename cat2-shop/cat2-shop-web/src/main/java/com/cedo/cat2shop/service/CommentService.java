package com.cedo.cat2shop.service;

import com.cedo.cat2shop.model.Comment;
import com.cedo.common.http.HttpResult;

/**
 * @Author chendong
 * @date 19-3-19 下午9:41
 */
public interface CommentService {
    HttpResult list(Integer current, Integer size);

    HttpResult findById(Long id);

    HttpResult add(Comment comment);

    HttpResult update(Comment comment);

    HttpResult delete(Long id);
}
