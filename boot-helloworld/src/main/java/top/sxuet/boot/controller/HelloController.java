package top.sxuet.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sxuet.boot.bean.Car;
import top.sxuet.boot.bean.Person;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-03 19:58
 */
// @ResponseBody
// @Controller
// 这两个可以合并为@RestController

@RestController // @ResponseBody、@Controller
public class HelloController {

  @Autowired Car car;

  @RequestMapping("/hello")
  public String handle01() {
    return "Hello,Spring Boot 2!";
  }

  @RequestMapping("/car")
  public String car() {
    return car.toString(); // Car{brand='五菱', price=1}
  }

  @Autowired Person person;

  @RequestMapping("/person")
  public Person person() {
    return person;
  }
}
