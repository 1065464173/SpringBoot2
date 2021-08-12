package top.sxuet.bootwebthymeleafadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sxuet.bootwebthymeleafadmin.bean.Account;
import top.sxuet.bootwebthymeleafadmin.bean.User;
import top.sxuet.bootwebthymeleafadmin.service.impl.AccountServiceImpl;

import javax.servlet.http.HttpSession;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 16:03
 */
@Controller
@Slf4j
public class IndexController {
  /**
   * 登录页
   *
   * @return
   */
  @GetMapping(value = {"/", "/login"})
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String main(User user, HttpSession session, Model model) {
    if (session.getAttribute("loginUser") != null) {
      return "redirect:/main.html";
    } else {
      if (StringUtils.hasLength(user.getName()) && StringUtils.hasLength(user.getPassword())) {
        session.setAttribute("loginUser", user);
        return "redirect:/main.html";
      } else {
        model.addAttribute("msg", "账号密码错误");
        return "login";
      }
    }
  }

  @GetMapping("/main.html")
  public String mainPage(HttpSession session) {
    log.info("当前方式是：{mianPage}");
    return "main";
  }

  @Autowired AccountServiceImpl service;

  @GetMapping("/acct")
  @ResponseBody
  public Account getById(@RequestParam("id") Long id) {
    return service.getAccountById(id);
  }
}
