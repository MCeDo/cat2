package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2shop.model.Cate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 分类
 * 
 * @author chenodng
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:43:29
 */
@Mapper
@Component
public interface CateDao extends BaseMapper<Cate> {

    /**
     * 查询类别名称
     * @param cateId
     * @return
     */
    @Select("select name from cate where id = #{cateId}")
    String findCateNameById(@Param("cateId") Integer cateId);
}
