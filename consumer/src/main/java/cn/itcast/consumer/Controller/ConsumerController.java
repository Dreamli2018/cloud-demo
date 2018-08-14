package cn.itcast.consumer.Controller;

import cn.itcast.consumer.pojo.User;
import cn.itcast.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consume")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

   @GetMapping("{ids}")
   public List<User> findAllUsers(@PathVariable("ids") List<Long> ids){
       return consumerService.findAllUsers(ids);
   }

}
