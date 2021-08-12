package top.sxuet.bootwebthymeleafadmin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 11:24
 */
@Component // 需要放到容器中
public class MyConHealthIndicator extends AbstractHealthIndicator {

  /**
   * 真实的检查方法
   *
   * @param builder
   * @throws Exception
   */
  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    Map<String, Object> map = new HashMap<>();
    // mongodb 获取连接测试
    // 开始检查
    if (1 == 1) {
      // 健康
      builder.status(Status.UP);
    } else {
      // 不健康
      builder.status(Status.OUT_OF_SERVICE);
      map.put("err", "连接超时");
      map.put("ms", 3000);
    }
    // 记录信息
    builder.withDetail("code", 100).withDetails(map);
  }
}
