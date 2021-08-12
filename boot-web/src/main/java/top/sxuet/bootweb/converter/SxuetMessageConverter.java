package top.sxuet.bootweb.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import top.sxuet.bootweb.bean.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 13:46
 */

/** 自定义的MessageConverter */
public class SxuetMessageConverter implements HttpMessageConverter {

  @Override
  public boolean canRead(Class clazz, MediaType mediaType) {
    return false; // 不读
  }

  @Override
  public boolean canWrite(Class clazz, MediaType mediaType) {
    return clazz.isAssignableFrom(Person.class); // 只写
  }

  /**
   * 服务器需要统计所有MessageConverter都能写出哪些内容 application/x-sxuet自定义类型
   *
   * @return
   */
  @Override
  public List<MediaType> getSupportedMediaTypes() {
    return MediaType.parseMediaTypes("application/x-sxuet");
  }

  @Override
  public Object read(Class clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {
    return null;
  }

  /**
   * 自定义数据的写出
   *
   * @param
   * @param contentType
   * @param outputMessage
   * @throws IOException
   * @throws HttpMessageNotWritableException
   */
  @Override
  public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {
    // 定义数据
    String data = ((Person) o).toString() + "我是自定义的SxuetMessageConverter转换而来的数据";
    // 写数据
    OutputStream body = outputMessage.getBody();
    body.write(data.getBytes());
  }
}
