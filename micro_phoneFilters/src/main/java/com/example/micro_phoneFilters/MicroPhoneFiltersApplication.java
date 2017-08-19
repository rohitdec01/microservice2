package com.example.micro_phoneFilters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroPhoneFiltersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPhoneFiltersApplication.class, args);
	}
}
