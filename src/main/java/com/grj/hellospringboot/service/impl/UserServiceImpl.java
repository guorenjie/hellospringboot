package com.grj.hellospringboot.service.impl;

import com.grj.hellospringboot.entity.User;
import com.grj.hellospringboot.mapper.UserMapper;
import com.grj.hellospringboot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guorenjie
 * @since 2019-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
