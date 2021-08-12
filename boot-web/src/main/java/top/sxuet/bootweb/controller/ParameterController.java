package top.sxuet.bootweb.controller;

import org.springframework.web.bind.annotation.*;
import top.sxuet.bootweb.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-05 18:56
 */
@RestController
public class ParameterController {

  /** ======================简单参数和注解======================= */
  @GetMapping("/car/{id}/owner/{username}") // car/1/owner/zhangsan
  public Map<String, Object> getCar(
      @PathVariable("id") Integer id,
      @PathVariable("username") String name,
      @PathVariable Map<String, Object> pv,
      @RequestHeader Map<String, String> headers,
      @RequestParam Map<String, String> params) {
    //      @CookieValue Cookie cookie

    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("name", name);
    map.put("pv", pv);
    map.put("headers", headers);
    map.put("params", params);
    //    map.put("cookie", cookie);
    return map;
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Map PostMethod(@RequestBody String content) {
    Map<String, Object> map = new HashMap<>();
    map.put("content", content);
    return map;
  }

  @GetMapping("/cars/{path}")
  public Map carsSell(
      @MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand) {
    // 需要开启矩阵变量,设置UrlPathHelper
    Map<String, Object> map = new HashMap<>();
    map.put("low", low);
    map.put("brand", brand);
    return map;
  }

  /** ======================自定义参数对象======================= */
  /**
   * 页面提交的get、post都可以和数据进行绑定
   *
   * @param user
   * @return
   */
  @PostMapping("/saveUser")
  public User saveUser(User user) {
    return user;
  }
}
