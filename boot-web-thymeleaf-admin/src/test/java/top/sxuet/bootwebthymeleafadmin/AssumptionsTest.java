package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @program: SpringBoot2
 * @description: junit5 前置条件测试
 * @author: Sxuet
 * @create: 2021-08-11 16:42
 */
@DisplayName("Assumptions前置条件测试")
public class AssumptionsTest {
  /**
   * 测试前置条件<br>
   * 断言就直接汇报到单元测试的测试报告里<br>
   * 而测试前置条件不通过的话就跳过测试，并且不汇报错误
   */
  @DisplayName("测试前置条件")
  @Test
  public void testAssumptions() {
    Assumptions.assumeTrue(false, "结果不是true");
    System.out.println("test1");
  }
}
