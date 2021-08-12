package top.sxuet.boot.bean;

import org.springframework.stereotype.Component;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-04 13:45
 */
@Component
public class User {
  private Integer id;
  private String name;
  private Integer age;

  public User(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public User() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
  }
}
