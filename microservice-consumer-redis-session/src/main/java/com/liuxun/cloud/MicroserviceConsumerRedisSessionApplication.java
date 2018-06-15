package com.liuxun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
public class MicroserviceConsumerRedisSessionApplication {


	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerRedisSessionApplication.class, args);
	}
}
