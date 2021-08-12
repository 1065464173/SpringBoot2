package top.sxuet.bootwebthymeleafadmin.service;

import top.sxuet.bootwebthymeleafadmin.bean.Account;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-11 12:54
 */
public interface AccountService {
  public Account getAccountById(Long id);
}
