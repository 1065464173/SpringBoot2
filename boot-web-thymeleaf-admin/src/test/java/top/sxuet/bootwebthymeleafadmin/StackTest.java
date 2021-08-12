package top.sxuet.bootwebthymeleafadmin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-11 22:01
 */
@DisplayName("嵌套测试")
public class StackTest {
  Stack<Object> stack;

  @Test
  @DisplayName("new Stack()")
  void isInstantiatedWithNew() {
    new Stack<>();
    // 嵌套测试情况下，外层的Test不能驱动内层的测试
    // 如内层的beforeEach不会作用到外层上
  }

  @Nested
  @DisplayName("when new")
  class WhenNew {

    @BeforeEach
    void createNewStack() {
      stack = new Stack<>();
    }

    /** 内层的可以驱动外层 */
    @Test
    @DisplayName("is empty")
    void isEmpty() {
      assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("throws EmptyStackException when popped")
    void throwsExceptionWhenPopped() {
      assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    @DisplayName("throws EmptyStackException when peeked")
    void throwsExceptionWhenPeeked() {
      assertThrows(EmptyStackException.class, stack::peek);
    }

    @Nested
    @DisplayName("after pushing an element")
    class AfterPushing {

      String anElement = "an element";

      @BeforeEach
      void pushAnElement() {
        stack.push(anElement);
      }

      @Test
      @DisplayName("it is no longer empty")
      void isNotEmpty() {
        assertFalse(stack.isEmpty());
      }

      @Test
      @DisplayName("returns the element when popped and is empty")
      void returnElementWhenPopped() {
        assertEquals(anElement, stack.pop());
        assertTrue(stack.isEmpty());
      }

      @Test
      @DisplayName("returns the element when peeked but remains not empty")
      void returnElementWhenPeeked() {
        assertEquals(anElement, stack.peek());
        assertFalse(stack.isEmpty());
      }
    }
  }
}
