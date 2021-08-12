package top.sxuet.boot.bean;

import lombok.*;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-05 12:32
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Color {
  private String name;
  private Integer code;
}
