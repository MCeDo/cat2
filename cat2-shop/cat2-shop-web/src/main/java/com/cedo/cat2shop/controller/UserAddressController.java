package com.cedo.cat2shop.controller;

import com.cedo.cat2shop.model.UserAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chendong
 * @date 19-3-13 下午9:30
 */
@RestController
@RequestMapping("/address")
public class UserAddressController extends BaseController<UserAddress> {
}
