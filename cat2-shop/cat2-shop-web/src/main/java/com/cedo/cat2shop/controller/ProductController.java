package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chendong
 * @date 19-3-13 下午8:56
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController<Product> {
}
