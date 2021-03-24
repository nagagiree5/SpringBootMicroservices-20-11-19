package com.springboot.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@RequestScope
@EnableEurekaClient
public class FriendMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendMicroservicesApplication.class, args);
	}

}
