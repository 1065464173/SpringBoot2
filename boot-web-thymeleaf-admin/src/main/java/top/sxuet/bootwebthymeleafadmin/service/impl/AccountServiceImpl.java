package top.sxuet.bootwebthymeleafadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sxuet.bootwebthymeleafadmin.bean.Account;
import top.sxuet.bootwebthymeleafadmin.mapper.AccountMapper;
import top.sxuet.bootwebthymeleafadmin.service.AccountService;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-10 14:34
 */
@Service
public class AccountServiceImpl implements AccountService {
  @Autowired AccountMapper mapper;

  @Override
  public Account getAccountById(Long id) {
    return mapper.getAccount(id);
  }
}
