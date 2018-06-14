  package com.liuxun.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

  @EnableTurbine
  @SpringBootApplication
  public class HystrixTurbine2Application {

	  public static void main(String[] args) {
		  SpringApplication.run(HystrixTurbine2Application.class, args);
	  }
  }

