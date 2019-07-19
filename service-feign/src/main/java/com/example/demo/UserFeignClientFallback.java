package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author liuqi
 * @Title: UserFeignClientFallback
 * @ProjectName springcloud
 * @Description: TODO
 * @date 2019/3/716:07
 */
@Component
public class UserFeignClientFallback implements UserFeignClient{

    @Override
    public String findById(String name) {
        return "请求访问异常";
    }

    @Override
    public String getUserId(String id) {
        return "请求访问异常";
    }

    @Override
    public String findUser(String user) {
        return "请求访问异常";
    }
}
