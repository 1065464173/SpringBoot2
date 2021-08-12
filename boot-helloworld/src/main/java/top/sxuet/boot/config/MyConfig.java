package top.sxuet.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sxuet.boot.bean.User;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-04 13:45
 */
/**
 * 配置类,类本身也是组件<br>
 * Full模式：proxyBeanMethods = true 默认为true<br>
 * Lite模式：proxyBeanMethods = false
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {
  /**
   * 组件添加。默认是单实例 外部无论调用多少次都会调用同一个对象
   *
   * @return
   */
  @Bean
  public User user01() {
    return new User(1, "sxuet", 22);
  }

  @Bean("sxuet")
  public User user02() {
    return new User(1, "sxuet", 18);
  }
}
