package com.grj.hellospringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.grj.hellospringboot.entity.Book;
import com.grj.hellospringboot.entity.User;
import com.grj.hellospringboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("获取所有用户")
    @RequestMapping("/getAll")
    public IPage<User> getAll(){
        IPage<User> iPage = userService.page(new Page<User>());
        return iPage;
    }


    @ApiOperation("根据用户id获取用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    @RequestMapping("/getUserById")
    public IPage<User> getUserById(String id){
        IPage<User> iPage = userService.page(new Page<User>(), Wrappers.<User>query().eq("id",id));
        return iPage;
    }
}
