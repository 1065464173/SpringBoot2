package top.sxuet.bootwebthymeleafadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("top.sxuet.bootwebthymeleafadmin.mapper")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@ServletComponentScan(basePackages = "top/sxuet/bootwebthymeleafadmin/servlet")
public class BootWebThymeleafAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootWebThymeleafAdminApplication.class, args);
  }
}
