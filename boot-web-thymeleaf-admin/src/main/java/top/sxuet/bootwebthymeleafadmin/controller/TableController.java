package top.sxuet.bootwebthymeleafadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.sxuet.bootwebthymeleafadmin.bean.User;
import top.sxuet.bootwebthymeleafadmin.service.UserService;

import java.util.List;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-08 09:38
 */
@Controller
public class TableController {
  @Autowired UserService userService;

  @GetMapping("/basic_table")
  public String basicTable() {
    return "table/basic_table";
  }

  @GetMapping("/dynamic_table")
  public String dynamicTable(Model model) {
    List<User> list = userService.list();
    model.addAttribute("users", list);
    return "table/dynamic_table";
  }

  @GetMapping("/responsive_table")
  public String responsiveTable() {
    return "table/responsive_table";
  }

  @GetMapping("/editable_table")
  public String editableTable() {
    return "table/editable_table";
  }

  @GetMapping("/pricing_table")
  public String pricingTable() {
    return "table/pricing_table";
  }
}
