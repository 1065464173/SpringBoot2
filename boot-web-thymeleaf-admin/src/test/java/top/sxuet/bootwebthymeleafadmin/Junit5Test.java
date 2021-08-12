package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * @program: SpringBoot2
 * @description: junit5常用的基本注解的示例
 * @author: Sxuet
 * @create: 2021-08-11 15:06
 */
@DisplayName("junit5功能测试")
public class Junit5Test {

  /** 测试时显示测试的名称 */
  @DisplayName("测试DisplayName注解")
  @Test
  public void testDisplayName() {
    System.out.println(1);
  }

  /** 测试禁用Disabled注解 */
  @Disabled // 禁用
  @DisplayName("测试2")
  @Test
  public void test2() {
    System.out.println(2);
  }

  /** 测试注解RepeatedTest，重复测试5次 */
  @RepeatedTest(5)
  @Test
  public void test3() {
    System.out.println(3);
  }

  /** 测试Timeout注解——设定单位时间之内没有执行完毕就显示超时 */
  @Timeout(value = 500, unit = TimeUnit.MICROSECONDS)
  @Test
  public void testTimeOut() {
    try {
      Thread.sleep(10);
      System.out.println(4);
    } catch (InterruptedException e) {
      // e.printStackTrace();
    }
  }

  /** 每个单元测试之前执行 */
  @BeforeEach
  public void testBeforeEach() {
    System.out.println("=====测试开始=====");
  }

  /** 每个单元测试之后执行 */
  @AfterEach
  public void testAfterEach() {
    System.out.println("=====测试结束=====");
  }
  /** 所有单元测试之前执行 必须是static */
  @BeforeAll
  public static void testBeforeAll() {
    System.out.println("=====所有测试开始=====");
  }
  /** 所有单元测试之后执行 必须是static */
  @AfterAll
  public static void testAfterAll() {
    System.out.println("=====所有测试结束=====");
  }
}
