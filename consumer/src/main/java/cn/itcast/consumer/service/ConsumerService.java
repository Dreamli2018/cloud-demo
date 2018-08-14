package cn.itcast.consumer.service;

import cn.itcast.consumer.mapper.UserDao;
import cn.itcast.consumer.mapper.UserFeigenClient;
import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConsumerService {
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private UserDao userDao;
    @Autowired
    private UserFeigenClient userFeigenClient;

    public List<User> findAllUsers(List<Long> ids) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
//        ServiceInstance instance = instances.get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
        List<User> users = new ArrayList<>();
        for (Long id : ids) {
//            String url =  "http://"+host+":"+port+"/user/"+id;
//            String url = "http://user-server/user/"+id;
//            User user = restTemplate.getForObject(url, User.class);
            User user = userFeigenClient.queryUserById(id);
            users.add(user);
        }
        return users;
    }
}
