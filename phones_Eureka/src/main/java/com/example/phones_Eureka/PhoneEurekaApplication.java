package com.example.phones_Eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class PhoneEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneEurekaApplication.class, args);
	}
}
