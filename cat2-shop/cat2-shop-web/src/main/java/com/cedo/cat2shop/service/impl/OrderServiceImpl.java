package com.cedo.cat2shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cedo.cat2shop.dao.OrderDao;
import com.cedo.cat2shop.model.Order;
import com.cedo.cat2shop.service.OrderService;
import com.cedo.cat2shop.util.PageUtil;
import com.cedo.common.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-19 下午11:36
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public HttpResult list(Map<String, Object> params) {
        IPage<Order> page = PageUtil.getPage(params);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        orderDao.selectPage(page, wrapper);
        return HttpResult.ok(page);
    }

    @Override
    public HttpResult findById(Long id) {
        return HttpResult.ok(orderDao.selectById(id));
    }

    @Override
    public HttpResult add(Order order) {
        return orderDao.insert(order)>0
                ?HttpResult.ok("添加成功", order.getId())
                :HttpResult.error("添加失败");
    }

    @Override
    public HttpResult update(Order order) {
        return orderDao.updateById(order)>0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }
}
