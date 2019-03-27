package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.cat2shop.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 闲置物品
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:39:40
 */
@Mapper
@Component
public interface ProductDao extends BaseMapper<Product> {

    IPage<Product> selectPageWithImages(IPage page, Map<String, Object> params);
}
