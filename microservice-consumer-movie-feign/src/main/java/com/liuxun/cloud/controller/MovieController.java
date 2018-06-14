package com.liuxun.cloud.controller;

import com.liuxun.cloud.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuxun.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	@GetMapping("/test")
	public  User testPost(User user){
		return userFeignClient.postUser(user);
	}

	// 注意：不特殊处理无法请求成功
//	@GetMapping("/test-get")
//	public  User testGet(User user){
//		return userFeignClient.getUser(user);
//	}
	@GetMapping("/test-get")
	public  User testGet(User user){
		return userFeignClient.getUser(user.getId(),user.getUsername());
	}

}
