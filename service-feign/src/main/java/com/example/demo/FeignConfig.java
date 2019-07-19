package com.example.demo;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuqi
 * @Title: FeignConfig
 * @ProjectName springcloud
 * @Description: TODO
 * @date 2019/3/716:09
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
