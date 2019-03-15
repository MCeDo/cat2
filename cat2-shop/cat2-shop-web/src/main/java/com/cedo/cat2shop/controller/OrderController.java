package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chendong
 * @date 19-3-13 下午9:29
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Order> {
}
