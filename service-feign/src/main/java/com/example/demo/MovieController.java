package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuqi
 * @Title: MovieController
 * @ProjectName springcloud
 * @Description: TODO
 * @date 2019/3/517:41
 */
@RequestMapping("/movies")
@RestController
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public String findById(@PathVariable String id) {
        System.out.print(id);


        String  liar ="说谎者";
        String  objective="目标的，客观的";
        String  generous ="慷慨的  大方的";
        String  individual="个人的，个别的，独特的";
        String  illegal="不合法的  非法的";
        String  conduct="行为 举止";
        String  automtic="";
        String byId = this.userFeignClient.findById( conduct);
        return byId;

    }

    @GetMapping("/getUserId")
    public String getUserId() {
        String byId = this.userFeignClient.getUserId("11");
        return byId;

    }

    /**
     * post请求
     */
    @PostMapping("/findUser")
    public String findUser(){
        return this.userFeignClient.findUser("152");
    };

    /**
     * 消息接受
     * @param message
     */
    @RabbitListener(queues = "hello")  //监听器监听指定的QueueName
    public void receive(String message) {
        System.out.println("接收消息:" + message);
    }

}
