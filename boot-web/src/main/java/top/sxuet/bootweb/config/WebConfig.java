package top.sxuet.bootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.sxuet.bootweb.bean.Pet;
import top.sxuet.bootweb.converter.SxuetMessageConverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-07 13:21
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {
  /**
   * 添加WebMvcConfigurer
   *
   * @return
   */
  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {

      /**
       * 添加自定义 参数转换器
       *
       * @param registry
       */
      @Override
      public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(
            new Converter<String, Pet>() {
              @Override
              public Pet convert(String source) {
                // 啊猫,3
                if (!StringUtils.isEmpty(source)) {
                  Pet pet = new Pet();
                  String[] split = source.split(",");
                  pet.setName(split[0]);
                  pet.setWeight(split[1]);
                  return pet;
                }
                return null;
              }
            });
      }

      /**
       * 添加自定义请求消息转换器
       *
       * @param converters
       */
      @Override
      public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new SxuetMessageConverter());
      }

      /**
       * 自定义内容协商策略（默认是参数和请求头）直接覆盖默认策略
       *
       * @param configurer
       */
      @Override
      public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypeMap = new HashMap<>();
        mediaTypeMap.put("json", MediaType.APPLICATION_JSON);
        mediaTypeMap.put("xml", MediaType.APPLICATION_ATOM_XML);
        mediaTypeMap.put("sxuet", MediaType.parseMediaType("application/x-sxuet"));
        ParameterContentNegotiationStrategy paramStrategy =
            new ParameterContentNegotiationStrategy(mediaTypeMap);
        HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
        configurer.strategies(Arrays.asList(paramStrategy, headerStrategy));
      }
    };
  }
}
