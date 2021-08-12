package top.sxuet.bootwebthymeleafadmin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-08 13:11
 */

/** 登录检查 1、配置好拦截器要拦截的请求 2、把配置放到容器中 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
  /**
   * 目标方法执行之前
   *
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 拦截日志记录
    String requestURI = request.getRequestURI();
    log.info("拦截请求路径是{" + requestURI + "}");

    // 登录逻辑检查
    HttpSession session = request.getSession();
    Object loginUser = session.getAttribute("loginUser");
    // 用户存在跳转，不存在则拦截。会拦截静态资源
    if (loginUser != null) {
      return true;
    }
    request.setAttribute("msg", "请先登录");
    request.getRequestDispatcher("/").forward(request, response);
    return false;
  }

  /**
   * 目标方法执行之后
   *
   * @param request
   * @param response
   * @param handler
   * @param modelAndView
   * @throws Exception
   */
  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    log.info("postHandle执行了", modelAndView);

    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  /**
   * 页面渲染后
   *
   * @param request
   * @param response
   * @param handler
   * @param ex
   * @throws Exception
   */
  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.info("afterCompletion执行了", ex);
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
