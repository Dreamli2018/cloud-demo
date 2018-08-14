package cn.itcast.consumer.mapper;

import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component // 表示该类为一个组件，将要被Spring所管理
public class UserFeignClientFallback implements UserFeigenClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUserName("网络访问异常，请明年再试");
        return user;
    }
}
