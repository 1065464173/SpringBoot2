package top.sxuet.bootwebthymeleafadmin.servlet;
/**
 * @program: SpringBoot2
 * @description: ${description}
 * @author: Sxuet
 * @create: 2021-08-09 15:16
 */
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
    filterName = "MyFilter",
    urlPatterns = {"/css/*", "/images/*"}) // *是servlet写法 **是spring写法
@Slf4j
public class MyFilter implements Filter {
  @Override
  public void init(FilterConfig config) throws ServletException {
    log.info("MyFilter..init");
  }

  @Override
  public void destroy() {
    log.info("MyFilter..destroy");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    log.info("MyFilter..doFilter");
    chain.doFilter(request, response);
  }
}
