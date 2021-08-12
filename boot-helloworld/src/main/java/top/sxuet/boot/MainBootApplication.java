package top.sxuet.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-03 19:56
 */

/**
 * 主程序类 <br>
 * @SpringBootApplication： 这是一个SpringBoot应用,宇哥模块只需要一个够了
 */
@SpringBootApplication
public class MainBootApplication {
  public static void main(String[] args) {
    // 1，返回ioc容器
    ConfigurableApplicationContext run = SpringApplication.run(MainBootApplication.class, args);
    // 2，查看容器的组件
    for (String beanDefinitionName : run.getBeanDefinitionNames()) {
      System.out.println(beanDefinitionName);
    }
    System.out.println(run.getBeanDefinitionCount());
  }
}
