package cn.itcast.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.itcast.user.mapper")
@EnableEurekaClient // 表示可以将自己注册到Eureka注册中心
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
