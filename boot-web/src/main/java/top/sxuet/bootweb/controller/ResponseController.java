package top.sxuet.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sxuet.bootweb.bean.Person;

import java.util.Date;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 09:32
 */
@Controller
public class ResponseController {
  /**
   * 如果是浏览器请求返回xml【application/xml】 jacksonJXmlConverter<br>
   * ajax请求 返回json【application/json】jacksonJsonConverter<br>
   * app发送请求，返回自定义协议数据【application/x-sxuet】 xxxConverter
   *
   * <p>步骤：<br>
   * 1，添加自定义MessageConverter 进系统底层<br>
   * 2，底层统计所有MessageConverter 能操作哪些类型<br>
   * 3，客户端内容协商 【sxuet-sxuet】
   *
   * @return
   */
  @GetMapping("/person")
  @ResponseBody
  public Person getPerson() {
    Person person = new Person();
    person.setAge(22);
    person.setBirth(new Date());
    return person;
  }
}
