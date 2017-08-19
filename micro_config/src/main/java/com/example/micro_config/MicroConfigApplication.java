package com.example.micro_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class MicroConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroConfigApplication.class, args);
	}
}
