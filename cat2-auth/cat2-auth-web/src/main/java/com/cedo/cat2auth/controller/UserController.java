package com.cedo.cat2auth.controller;

import com.cedo.cat2auth.model.User;
import com.cedo.cat2auth.service.UserService;
import com.cedo.common.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @Author chendong
 * @date 19-3-3 下午2:05
 */
@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("增加用户")
    @PostMapping
    @RequiresPermissions("user:add")
    public HttpResult add(@RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation("修改用户")
    @PutMapping
    @RequiresPermissions("user:update")
    public HttpResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    @RequiresPermissions("user:del")
    public HttpResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @ApiOperation("查询用户")
    @GetMapping("/{id}")
    @RequiresPermissions("user:list")
    public HttpResult get(@PathVariable("id") Long id) {
        HttpResult result = userService.findUserById(id);
        return result;
    }

    @GetMapping
    @RequiresPermissions("user:list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", required = true, defaultValue = "0"),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query", required = true, defaultValue = "10"),
            @ApiImplicitParam(name = "type", value = "角色ID", paramType = "query", defaultValue = "1")
    })
    public HttpResult list(@ApiIgnore @RequestParam Map<String, Object> params) {
        return userService.list(params);
    }
}
