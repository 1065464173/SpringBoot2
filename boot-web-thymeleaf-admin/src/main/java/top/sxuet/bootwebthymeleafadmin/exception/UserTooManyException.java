package top.sxuet.bootwebthymeleafadmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-09 14:51
 */
// HttpStatus.FORBIDDEN 403
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "user too many")
public class UserTooManyException extends Exception {
  public UserTooManyException(String message) {
    super(message);
  }
}
