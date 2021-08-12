package top.sxuet.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-05 19:44
 */
@Controller
public class RequestController {

  /** =======================复杂参数======================= */
  @GetMapping("/goto")
  public String goToPage(HttpServletRequest request) {
    request.setAttribute("msg", "成功了");
    return "forward:/success";
  }

  @GetMapping("/success")
  @ResponseBody
  public Map<String, Object> success(
      @RequestAttribute("msg") String msg, HttpServletRequest request) {
    Object msg1 = request.getAttribute("msg");
    Map<String, Object> map = new HashMap<>();
    Object hello = request.getAttribute("hello");
    Object world = request.getAttribute("world");
    Object msg2 = request.getAttribute("msg");

    map.put("msg1", msg1);
    map.put("注解msg", msg);

    map.put("hello", hello);
    map.put("world", world);
    map.put("msg2", msg2);
    return map;
  }

  @GetMapping("/param")
  public String complicateParam(
      Map<String, Object> map,
      Model model,
      HttpServletRequest request,
      HttpServletResponse response) {
    map.put("hello", "world666");
    model.addAttribute("world", "hellomodle");
    request.setAttribute("msg", "hellorequest");
    Cookie cookie = new Cookie("ci", "v1");
    cookie.setDomain("localhost");
    response.addCookie(cookie);
    return "forward:/success";
  }
}
