package top.sxuet.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 15:43
 */
@Controller
public class ViewController {
  @GetMapping("/sxuet")
  public String sxuet(Model model) {
    // model中的数据会被放在请求域中  request.setAttribute
    model.addAttribute("msg", "hello,sxuet~");
    model.addAttribute("link", "http://www.baidu.com");
    // thymeleaf已经配置好了页面的视图解析器
    return "success";
  }
}
