package cn.itcast.consumer.mapper;

        import cn.itcast.consumer.pojo.User;
        import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.web.client.RestTemplate;
        import sun.swing.BakedArrayList;

        import java.util.ArrayList;
        import java.util.List;
@Component
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "findUserByIdFallback")
    public User findUserById(Long id) {
//        String url =  "http://"+host+":"+port+"/user/"+id;
//        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        // 远程查询默认超市时间为1s，只要超过1s，就会报错
        String url = "http://user-server/user/"+id;
        Long start = System.currentTimeMillis();
        User user = restTemplate.getForObject(url, User.class);
        Long end = System.currentTimeMillis();
        logger.info("查询用时 {}",end-start);
        return user;
    }

    public User findUserByIdFallback(Long id){
        User user = new User();
        user.setId(id);
        user.setUserName("你要查询的用户信息初出现异常");
        return user;
    }

}
