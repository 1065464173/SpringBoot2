package top.sxuet.bootwebthymeleafadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.sxuet.bootwebthymeleafadmin.bean.User;
import top.sxuet.bootwebthymeleafadmin.mapper.UserMapper;
import top.sxuet.bootwebthymeleafadmin.service.UserService;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-11 12:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
