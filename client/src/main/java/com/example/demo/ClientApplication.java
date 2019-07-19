package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 在application中加入注解@EnableEurekaClient，表明自己属于一个生产者。
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Value("${server.port}")
	String port;

	@RequestMapping("/hellow")
	public Object hellow(@RequestParam String name)
	{
		Map<String,Object> map=new HashMap();
		User user=new User(1,"fys");
		String s="hi " + name + ",i am from port:" + port;
		map.put("user",user);
		map.put("s",s);
		return map;
	}

	@GetMapping("/find/{id}")
	public String findById(@PathVariable String  id) {
		return "liser"+port;
	}

	@PostMapping("/findUser")
	public String findOne(@RequestBody String userName) {
		return "李四"+port;
	}


	@RequestMapping("/hi")
	public String home(@RequestParam String name)
	{
		return name+port;
	}

}
