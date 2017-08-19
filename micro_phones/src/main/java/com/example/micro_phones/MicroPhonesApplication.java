package com.example.micro_phones;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableDiscoveryClient  
public class MicroPhonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPhonesApplication.class, args);
	}

	/**
	 * @param ctx
	 * @return
	 */
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}*/
}
