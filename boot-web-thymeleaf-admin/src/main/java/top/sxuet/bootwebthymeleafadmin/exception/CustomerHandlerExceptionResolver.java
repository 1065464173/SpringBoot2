package top.sxuet.bootwebthymeleafadmin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-09 15:04
 */

/** 自定义异常解析器 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE) // 优先级
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    try {
      response.sendError(511, "我喜欢的错误");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ModelAndView();
  }
}
