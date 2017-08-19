package com.example.micro_Phone_Plans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroPhonePlansApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPhonePlansApplication.class, args);
	}
}
