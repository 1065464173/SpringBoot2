package top.sxuet.bootwebthymeleafadmin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 11:34
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

  @Override
  public void contribute(Info.Builder builder) {
    builder
        .withDetail("msg", "你好")
        .withDetail("hello", "sxuet")
        .withDetails(Collections.singletonMap("world", "666"));
  }
}
