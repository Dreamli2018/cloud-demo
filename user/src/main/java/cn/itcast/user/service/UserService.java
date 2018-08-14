package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(Long id) {
        try {
            int time = new Random().nextInt(2000);
            System.out.println("睡了多长时间"+time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectByPrimaryKey(id);
    }
}
