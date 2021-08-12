package top.sxuet.bootwebthymeleafadmin.exception;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-09 14:08
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 全局处理mvc controller异常 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
  public String handleArithException() {
    return "login";
  }
}
