package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.sxuet.bootwebthymeleafadmin.mapper.UserMapper;
import top.sxuet.bootwebthymeleafadmin.service.impl.AccountServiceImpl;
import top.sxuet.bootwebthymeleafadmin.service.impl.CityServiceImpl;

@SpringBootTest
class BootWebThymeleafAdminApplicationTests {

  @Autowired AccountServiceImpl accountService;
  @Autowired CityServiceImpl cityService;
  @Autowired UserMapper mapper;

  @Test
  void contextLoads() {
    // System.out.println(accountService.getAccountById(1L));
    System.out.println(cityService.findById(1));
  }

  @Test
  public void testUserMapper() {
    System.out.println(mapper.selectById(1));
  }
}
