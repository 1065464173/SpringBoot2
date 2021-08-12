package top.sxuet.bootwebthymeleafadmin.servlet;
/**
 * @program: SpringBoot2
 * @description: ${description}
 * @author: Sxuet
 * @create: 2021-08-09 15:20
 */
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
@Slf4j
public class MyListener
    implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

  public MyListener() {}

  /**
   * 初始化
   *
   * @param sce
   */
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("MyListener..listened..init");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    log.info("MyListener..listened..destroy");
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    /* Session is created. */
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    /* Session is destroyed. */
  }

  @Override
  public void attributeAdded(HttpSessionBindingEvent sbe) {
    /* This method is called when an attribute is added to a session. */
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent sbe) {
    /* This method is called when an attribute is removed from a session. */
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent sbe) {
    /* This method is called when an attribute is replaced in a session. */
  }
}
