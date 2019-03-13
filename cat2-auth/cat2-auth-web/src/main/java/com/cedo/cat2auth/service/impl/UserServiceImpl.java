package com.cedo.cat2auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cedo.cat2auth.dao.UserMapper;
import com.cedo.cat2auth.dto.LoginDTO;
import com.cedo.cat2auth.model.Menu;
import com.cedo.cat2auth.model.User;
import com.cedo.cat2auth.service.MenuService;
import com.cedo.cat2auth.service.UserService;
import com.cedo.cat2auth.service.UserTokenService;
import com.cedo.common.constant.RoleConstant;
import com.cedo.common.exception.RestException;
import com.cedo.common.http.HttpResult;
import com.cedo.common.util.MathUtil;
import com.cedo.redis.RedisKeys;
import com.cedo.redis.RedisUtil;
import com.cedo.security.vo.UserToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Author chendong
 * @date 19-3-1 下午12:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public HttpResult login(LoginDTO loginDTO) {
        User user = this.findUserByUsername(loginDTO.getUsername());
        if (user==null || !user.getPassword().equals(sha256Hash(loginDTO.getPassword(), user.getSalt()))) {
            throw new RestException(HttpStatus.UNAUTHORIZED.value(), "帐号或者密码错误");
        }
        // 创建token
        UserToken userToken = userTokenService.createToken(user.getId());
        // 查出权限放到redis缓存
        this.findPermission(user.getId());
        return HttpResult.ok(userToken);
    }

    @Override
    public HttpResult logout(String token) {
        //清除redis缓存,user:token:XXX
        // TODO 未做user:permission:XX和token:userId:xx的缓存清除
        redisUtil.del(RedisKeys.getUserByToken(token));
        return HttpResult.ok("退出登录成功！");
    }

    @Override
    public User findUserByUsername(String username) {
        Wrapper<User> wrapper = new QueryWrapper<>();
        ((QueryWrapper<User>) wrapper).eq("username", username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public void findPermission(Long id) {
        List<Menu> menuList;
        // id为1则是超级管理员，查出所有权限
        if (id==1) {
            menuList = menuService.findAll();
        }else {
            menuList = menuService.findMenuByUserId(id);
        }
        Set<String> permission = new HashSet<>();
        menuList.stream().forEach(m -> {
            if (m!=null)permission.add(m.getPermission());
        });

        redisUtil.set(RedisKeys.getPermissionByUserId(id), permission);
    }

    @Override
    public HttpResult register(User user) {
        user.setRoleId(RoleConstant.NORMAL_USER);
        user.setSalt(MathUtil.random());
        user.setPassword(sha256Hash(user.getPassword(), user.getSalt()));
        return userMapper.insert(user)>0
                ? HttpResult.ok("注册成功哥")
                : HttpResult.error("注册失败！请重新注册");
    }

    @Override
    public HttpResult findUserById(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new RestException(HttpStatus.NOT_FOUND.value(), "用户不存在");
        }
        return HttpResult.ok(user);
    }

    @Override
    public HttpResult add(User user) {
        int insert = userMapper.insert(user);
        return insert>0
                ?HttpResult.ok("添加成功")
                :HttpResult.error("添加失败！");
    }

    @Override
    public HttpResult update(User user) {
        return userMapper.updateById(user)>0
                ?HttpResult.ok("修改成功")
                :HttpResult.error("修改失败");
    }

    @Override
    public HttpResult list(Integer current, Integer size) {
        IPage page = new Page(current, size);
        Wrapper<User> wrapper = new QueryWrapper<>();
        IPage list = userMapper.selectPage(page, wrapper);
        return HttpResult.ok("包含分页的数据", list);
    }

    @Override
    public HttpResult delete(Long id) {
        int count = userMapper.deleteById(id);
        return HttpResult.ok("删除成功");
    }

    /**
     * sha256Hash 加密
     * @param str
     * @param salt
     * @return
     */
    private String sha256Hash(String str, String salt) {
        return new Sha256Hash(str, salt).toHex();
    }
}
