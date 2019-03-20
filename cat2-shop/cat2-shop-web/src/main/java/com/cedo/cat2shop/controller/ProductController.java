package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Product;
import com.cedo.cat2shop.service.ProductService;
import com.cedo.common.http.HttpResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-13 下午8:56
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", required = true, defaultValue = "0"),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query", required = true, defaultValue = "10"),
            @ApiImplicitParam(name = "pay", value = "是否支付", paramType = "query")
    })
    public HttpResult list(@ApiIgnore @RequestParam Map<String, Object> params) {
        return productService.list(params);
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public HttpResult add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping
    public HttpResult update(@RequestBody Product product) {
        return productService.update(product);
    }
}