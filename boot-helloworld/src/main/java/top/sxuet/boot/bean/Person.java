package top.sxuet.boot.bean;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-05 13:07
 */
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** yaml数据演示 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
@ToString
public class Person {
  // 字面量
  private String name;
  private Boolean boss;
  private Date birth;
  private Integer age;

  // 对象
  private Pet pet;
  private Map<String, Object> score;
  private Set<Double> salarys;
  private Map<String, List<Pet>> allPets;

  // 数组
  private String[] interests;
  private List<String> animal;
}
