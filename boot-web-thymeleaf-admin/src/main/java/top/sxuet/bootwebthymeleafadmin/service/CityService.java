package top.sxuet.bootwebthymeleafadmin.service;

import top.sxuet.bootwebthymeleafadmin.bean.City;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-11 12:54
 */
public interface CityService {
  public City findById(long id);
}
