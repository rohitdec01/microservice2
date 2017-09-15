package com.example.phones_zuul_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit
 *
 */
@SpringBootApplication
@EnableZuulProxy
@RestController
public class PhonesZuulGatewayApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhonesZuulGatewayApplication.class, args);
	}
	
	/**
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "This is Root of Zull Gateway.";
	}
}
