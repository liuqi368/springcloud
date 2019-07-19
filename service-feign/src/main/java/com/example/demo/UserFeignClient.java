package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuqi
 * @Title: UserFeignClient
 * @ProjectName springcloud
 * @Description: TODO
 * @date 2019/3/517:37
 */
@FeignClient(name = "service-hi",fallback = UserFeignClientFallback.class ,configuration = FeignConfig.class)
public interface UserFeignClient {

    @RequestMapping(value = "/hi/{name}",method = RequestMethod.GET)
    String findById( String name);

    /**
     * get请求
     */
    @GetMapping("/find/{id}")
    String getUserId(@PathVariable("id") String id); // PathVariable注解必须得设置value

    /**
     * post请求
     */
    @PostMapping("/findUser")
    String findUser(@RequestBody String userName);    /*@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    String findById(@PathVariable("id") String id);*/
}
