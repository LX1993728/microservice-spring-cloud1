package com.liuxun.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.liuxun.cloud.entity.User;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		// http://localhost:7900/simple/
		// VIP: Virtual IP  http://microservice-provider-user/  即虚拟IP 服务提供者的ServiceId （spring.application.name）
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public String test(){
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("111"+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());

		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("222"+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());
		return "1";
	}

	@GetMapping("/list-all")
	public List<User> listAll() {
		// wrong
		//    List<User> list = this.restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
		//    for (User user : list) {
		//      System.out.println(user.getId());
		//    }

		// right
		User[] users = this.restTemplate.getForObject("http://microservice-provider-user/list-all", User[].class);
		List<User> list2 = Arrays.asList(users);
		for (User user : list2) {
			System.out.println(user.getId());
		}

		return list2;
	}

}
