package top.sxuet.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: boot-helloworld
 * @description:
 * @author: Sxuet
 * @create: 2021-08-04 14:46
 */
@Component
@ConfigurationProperties(prefix = "mycar") // 注入属性，属性为application.properties内前缀为mycar的属性
public class Car {
  private String brand;
  private Integer price;

  @Override
  public String toString() {
    return "Car{" + "brand='" + brand + '\'' + ", price=" + price + '}';
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Car() {}

  public Car(String brand, Integer price) {
    this.brand = brand;
    this.price = price;
  }
}
