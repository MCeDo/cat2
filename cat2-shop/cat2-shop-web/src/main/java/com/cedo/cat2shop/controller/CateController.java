package com.cedo.cat2shop.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cedo.cat2shop.dao.BaseDao;
import com.cedo.cat2shop.model.Cate;
import com.cedo.cat2shop.service.CateService;
import com.cedo.common.http.HttpResult;
import com.cedo.common.validator.AddGroup;
import com.cedo.common.validator.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chendong
 * @date 19-3-13 下午4:08
 */
@RestController
@RequestMapping("/cate")
//public class CateController extends BaseController<Cate>{
public class CateController {
    @Autowired
    private CateService cateService;

    @GetMapping
    public HttpResult list(@RequestParam(defaultValue = "0") Integer current, @RequestParam(defaultValue = "100") Integer size) {
        return cateService.list(current, size);
    }

    @GetMapping("/{id}")
    public HttpResult get(@PathVariable Long id) {
        return cateService.findById(id);
    }

    @PostMapping
    public HttpResult add(@RequestBody @Validated(AddGroup.class) Cate cate) {
        return cateService.add(cate);
    }

    @PutMapping
    public HttpResult update(@RequestBody @Validated(UpdateGroup.class) Cate cate) {
        return cateService.update(cate);
    }

    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable Long id) {
        return cateService.delete(id);
    }
}
