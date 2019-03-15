package com.cedo.cat2shop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2shop.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 订单
 * 
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2019-03-02 20:40:25
 */
@Mapper
@Component
public interface OrderDao extends BaseMapper<Order> {
	
}
