package com.cedo.cat2auth.controller;

import com.cedo.cat2auth.dto.LoginDTO;
import com.cedo.cat2auth.model.User;
import com.cedo.cat2auth.service.UserService;
import com.cedo.cat2auth.service.UserTokenService;
import com.cedo.common.exception.RestException;
import com.cedo.common.http.HttpResult;
import com.cedo.security.oauth2.OAuth2Filter;
import com.cedo.security.vo.UserToken;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @RequestMapping("/index")
    @RequiresPermissions("user:list")
    public String index() {
        return "index";
    }

    @PostMapping("/logout")
    public HttpResult logout(HttpServletRequest request) {
        String token = request.getHeader(OAuth2Filter.TOKEN);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(OAuth2Filter.TOKEN);
        }
        return userService.logout(token);
    }

    @PostMapping("/register")
    public HttpResult register(@RequestBody User user) {
        return userService.register(user);
    }
}
