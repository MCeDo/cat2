package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Order;
import com.cedo.cat2shop.service.OrderService;
import com.cedo.common.http.HttpResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-13 下午9:29
 */
@RestController
@RequestMapping("/order")
//public class OrderController extends BaseController<Order> {
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", required = true, defaultValue = "0"),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query", required = true, defaultValue = "10"),
            @ApiImplicitParam(name = "pay", value = "是否支付", paramType = "query")
    })
    public HttpResult list(@ApiIgnore @RequestParam Map<String, Object> params) {
        return orderService.list(params);
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public HttpResult add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @PutMapping
    public HttpResult update(@RequestBody Order order) {
        return orderService.update(order);
    }
}
