package top.sxuet.bootwebthymeleafadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-10 10:37
 */
// 引入官方starter就不需要自己写配置类了
// @Configuration
public class MyDataSourceConfig {
  /**
   * 自定义druid 连接池 hikari连接池自动失效
   *
   * <p>filters:stat 监控统计功能<br>
   * filters:wall 开启防火墙功能
   *
   * @return
   */
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    // 打开监控统计功能——set方法可以在配置文件中配置
    // dataSource.setFilters("stat,wall");

    return dataSource;
  }

  /**
   * 开启druid监控页功能
   *
   * @return
   */
  @Bean
  public ServletRegistrationBean<StatViewServlet> statViewServlet() {
    // 开启监控页
    StatViewServlet statViewServlet = new StatViewServlet();
    ServletRegistrationBean<StatViewServlet> registrationBean =
        new ServletRegistrationBean<>(statViewServlet, "/druid/*");
    // 添加监控页登录功能
    registrationBean.addInitParameter("loginUsername", "admin");
    registrationBean.addInitParameter("loginPassword", "123456");
    return registrationBean;
  }

  /**
   * 开启web监控功能<br>
   *
   * @return
   */
  @Bean
  public FilterRegistrationBean webStatFilter() {
    WebStatFilter webStatFilter = new WebStatFilter();
    FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean =
        new FilterRegistrationBean<>(webStatFilter);
    // 设置过滤路径
    filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
    filterFilterRegistrationBean.addInitParameter(
        "exclusions", "*.js,*.gif,*.png,*.css,*.ico,/druid/*");
    return filterFilterRegistrationBean;
  }
}
