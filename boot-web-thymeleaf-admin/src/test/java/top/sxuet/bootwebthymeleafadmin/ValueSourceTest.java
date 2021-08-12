package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 09:36
 */
@DisplayName("参数化测试")
public class ValueSourceTest {
  /**
   * 普通传参
   *
   * @param i
   */
  @ParameterizedTest
  @DisplayName("参数化测试")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void testParameterized(int i) {
    System.out.println(i);
  }

  /**
   * 允许入参为null或空格
   *
   * @param text
   */
  @DisplayName("NullSource、EmptySource测试")
  @ParameterizedTest
  // @NullSource
  // @EmptySource
  @NullAndEmptySource
  @ValueSource(strings = {" ", "   ", "\t", "\n"})
  void nullEmptyAndBlankStrings(String text) {
    assertTrue(text == null || text.trim().isEmpty());
  }

  /**
   * 提供枚举类参数的入参
   *
   * @param unit
   */
  @DisplayName("枚举入参测试1")
  @ParameterizedTest
  @EnumSource(ChronoUnit.class)
  void testWithEnumSource(TemporalUnit unit) {
    assertNotNull(unit);
  }

  @DisplayName("枚举入参测试2")
  @ParameterizedTest
  @EnumSource
  void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
    assertNotNull(unit);
  }

  @DisplayName("枚举入参测试3")
  @ParameterizedTest
  @EnumSource(names = {"DAYS", "HOURS"})
  void testWithEnumSourceInclude(ChronoUnit unit) {
    assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
  }

  /**
   * 使用比较多 返回值必须是静态的流类型 参数为方法名
   *
   * @param argument
   */
  @DisplayName("方法返回值入参")
  @ParameterizedTest
  @MethodSource("stringProvider")
  void testWithExplicitLocalMethodSource(String argument) {
    assertNotNull(argument);
  }

  static Stream<String> stringProvider() {
    return Stream.of("apple", "banana", "orange");
  }
}
