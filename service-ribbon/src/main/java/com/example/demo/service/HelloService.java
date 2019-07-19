package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuqi
 * @Title: HelloService
 * @ProjectName springcloud
 * @Description: TODO
 * @date 2019/3/514:44
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name)
    {
        ResponseEntity<Object> forEntity = restTemplate.getForEntity("http://SERVICE-HI/hellow?name=" + name, Object.class);
        //Object forObject = restTemplate.getForEntity("http://SERVICE-HI/hi?name=" + name, Object.class);
        //Object friends = restTemplate.getForEntity("http://client-user/hi?name=" + name, String.class);
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
        //return "";
    }
    public String hiError(String name)
    {
        return "hey " +
                name + ", there is some problem with hi page";
    }
}
