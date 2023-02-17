package com.springmicroservices.discoveryservers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServersApplication.class, args);
	}

}
