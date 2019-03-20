package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2shop.model.ProductPic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物品图片
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:44:34
 */
@Mapper
public interface ProductPicDao extends BaseMapper<ProductPic> {
	
}
