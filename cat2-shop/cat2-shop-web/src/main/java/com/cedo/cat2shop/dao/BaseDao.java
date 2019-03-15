package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author chendong
 * @date 19-3-13 下午8:50
 */
@Mapper
@Component
public interface BaseDao<T> extends BaseMapper<T> {
}
