package com.ironhack.leadproxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeadProxyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LeadProxyServiceApplication.class, args);
	}

}
