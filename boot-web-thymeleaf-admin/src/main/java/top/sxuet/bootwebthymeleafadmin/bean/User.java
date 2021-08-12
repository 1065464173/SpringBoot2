package top.sxuet.bootwebthymeleafadmin.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 16:37
 */
@Data
@TableName("user")
public class User {
  private Integer id;
  private String name;
  private String password;
  private String address;
  private String phone;
}
