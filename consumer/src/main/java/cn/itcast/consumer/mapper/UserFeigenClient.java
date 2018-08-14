package cn.itcast.consumer.mapper;

import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-server",fallback = UserFeignClientFallback.class) // fefign 会去注册中心找id为user-server的服务
public interface UserFeigenClient {
    @GetMapping("/user/{id}") // http://localhost:8081/user/id ,user-server 即代表了locahost：8081或者locahost:8082
    User queryUserById(@PathVariable("id") Long id);
}
