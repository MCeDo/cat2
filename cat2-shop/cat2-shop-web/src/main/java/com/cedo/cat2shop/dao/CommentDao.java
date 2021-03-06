package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2shop.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 留言类
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:41:59
 */
@Mapper
@Component
public interface CommentDao extends BaseMapper<Comment> {
	
}
