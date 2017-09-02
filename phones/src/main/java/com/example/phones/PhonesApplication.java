package com.example.phones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rb611j
 *
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableCaching
//@EnableAutoConfiguration
/* @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) */
public class PhonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonesApplication.class, args);
	}
}
