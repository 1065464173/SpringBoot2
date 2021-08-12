package top.sxuet.bootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-05 14:57
 */
@RestController
public class HelloController {
  /** 静态路径请求的顺序 没有controller再执行静态查找，再没有404 */
  @RequestMapping("gaga.jpeg")
  public String hello() {
    return "aaa";
  }
}
