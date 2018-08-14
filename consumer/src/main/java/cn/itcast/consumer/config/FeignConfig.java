package cn.itcast.consumer.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 设置feign发送http请求输出日志的级别
 * 一般选择full，即代表输出所有
 */
@Configuration
public class FeignConfig {
    @Bean
  Logger.Level feignLoggerLevel(){
      return Logger.Level.FULL;
  }

}
