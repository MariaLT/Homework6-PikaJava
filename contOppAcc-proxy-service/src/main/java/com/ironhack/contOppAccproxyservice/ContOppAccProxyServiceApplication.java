package com.ironhack.contOppAccproxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ContOppAccProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContOppAccProxyServiceApplication.class, args);
	}

}
