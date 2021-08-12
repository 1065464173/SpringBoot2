package top.sxuet.bootwebthymeleafadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.sxuet.bootwebthymeleafadmin.interceptor.LoginInterceptor;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-08 13:13
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
  /**
   * 用户登录的拦截器
   *
   * @param registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**") // 默认拦截所有请求包括静态资源
        .excludePathPatterns(
            "/", "/login", "/css/**", "/js/**", "/fonts/**", "/images/**"); // 对部分请求放行
  }
}
