package top.sxuet.bootwebthymeleafadmin.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import top.sxuet.bootwebthymeleafadmin.servlet.MyFilter;
import top.sxuet.bootwebthymeleafadmin.servlet.MyListener;
import top.sxuet.bootwebthymeleafadmin.servlet.MyServlet;

import java.util.Arrays;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-09 15:25
 */

/** web原生组件的第二种方式——基于spring配置 */
// @Configuration(proxyBeanMethods = true)
public class MyRegistConfig {
  @Bean
  public ServletRegistrationBean myServlet() {
    MyServlet myServlet = new MyServlet();
    return new ServletRegistrationBean(myServlet, "/my");
  }

  @Bean
  public FilterRegistrationBean myFilter() {
    MyFilter myFilter = new MyFilter();
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myListener() {
    MyListener myListener = new MyListener();
    return new ServletListenerRegistrationBean(myListener);
  }
}
