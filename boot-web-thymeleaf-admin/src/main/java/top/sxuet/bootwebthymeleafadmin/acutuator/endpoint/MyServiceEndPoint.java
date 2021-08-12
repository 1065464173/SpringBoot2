package top.sxuet.bootwebthymeleafadmin.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-12 13:04
 */
@Endpoint(id = "myservice")
@Component
public class MyServiceEndPoint {
  /**
   * 端点读操作
   *
   * @return
   */
  @ReadOperation
  public Map getDockerInfo() {
    return Collections.singletonMap("dockerInfo", "docker start");
  }

  @WriteOperation
  public void stopDocker() {
    System.out.println("docker stopped");
  }
}
