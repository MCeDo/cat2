package com.cedo.cat2shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.cat2shop.dao.CommentDao;
import com.cedo.cat2shop.model.Comment;
import com.cedo.cat2shop.service.CommentService;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chendong
 * @date 19-3-19 下午9:42
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public HttpResult list(Integer current, Integer size) {
        IPage<Comment> page = new Page<>(current, size);
        Wrapper<Comment> wrapper = new QueryWrapper<>();
        commentDao.selectPage(page, wrapper);
        return HttpResult.ok(page);
    }

    @Override
    public HttpResult findById(Long id) {
        return HttpResult.ok(commentDao.selectById(id));
    }

    @Override
    public HttpResult add(Comment comment) {
        return commentDao.insert(comment)>0
                ?HttpResult.ok("添加成功")
                :HttpResult.error("添加失败");
    }

    @Override
    public HttpResult update(Comment comment) {
        return commentDao.updateById(comment)>0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }
}
