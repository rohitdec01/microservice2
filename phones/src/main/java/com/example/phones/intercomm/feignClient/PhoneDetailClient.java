package com.example.phones.intercomm.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.phones.entity.PhoneDetail;

/**
 * @author Rohit 
 * This is Feign client which intract with the other microservice
 *         with the help of discovery client. In the resttemplate we were
 *         passing the URlbut in the Feign client we are passing the service
 *         name and it is resolving the service name from eureka server.
 */
@FeignClient("PHONESDETAIL-SERVICE")
public interface PhoneDetailClient {

	/**
	 * @param phoneId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/phoneDetail/phone/{phoneId}")
	public PhoneDetail getPhoneDetailById(@PathVariable("phoneId") Long phoneId);

}
