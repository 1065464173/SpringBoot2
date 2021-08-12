package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: SpringBoot2
 * @description: junit5常用断言的示例
 * @author: Sxuet
 * @create: 2021-08-11 16:18
 */
@DisplayName("Assertions断言测试")
public class AssertionsTest {

  /**
   * 测试简单断言-一旦断言失败，后面代码概不执行<br>
   * assertEquals是否相等<br>
   * assertSame是否是同一个<br>
   * assertArrayEquals 数组内容是否一致
   */
  @DisplayName("测试简单断言")
  @Test
  public void testSimpleAssertions() {
    int cal = 2 + 3;
    assertEquals(5, cal, "业务逻辑计算失败");

    Object o1 = new Object();
    Object o2 = new Object();
    assertSame(o1, o2, "比较对象不一致");

    assertArrayEquals(new int[] {1, 3}, new int[] {1, 2}, "数组内容不一致");
  }

  /**
   * 测试组合断言 测试的一组断言都成功，才成功<br>
   * assertAll(组合名，assert1,assert2...)
   */
  @DisplayName("组合断言")
  @Test
  public void testAllAssertions() {
    assertAll("test", () -> assertTrue(true && true, "结果不为真"), () -> assertEquals(1, 2, "结果不为2"));
  }

  /** 超时断言 测试方法时间超过指定时间将会异常 */
  @Test
  @DisplayName("超时测试")
  public void timeoutTest() {
    // 如果测试方法时间超过1s将会异常
    assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
  }
  /**
   * 异常断言-断定业务逻辑一定出现异常，抛出异常才算断言成功 <br>
   * assertThrows(异常类型，业务逻辑，消息)
   */
  @DisplayName("异常断言")
  @Test
  public void testException() {
    assertThrows(
        ArithmeticException.class,
        () -> {
          int i = 10 / 2;
        },
        "本应该发生的数学异常没有发生");
  }

  /** 快速断言-直接判断测试会否失败 */
  @DisplayName("快速断言")
  @Test
  public void testFail() {
    if (2 == 2) {
      fail("测试失败");
    }
  }
}
