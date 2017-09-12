package com.example.phonesDetails.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phonesDetails.entity.PhoneDetail;
import com.example.phonesDetails.repository.PhoneDetailRepository;
import com.example.phonesDetails.service.PhoneDetailService;

/**
 * @author Rohit
 *
 */
@Service
public class InitDbService {
	
	@Autowired
	private PhoneDetailService phoneDetailService;
	
	public InitDbService() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init () {
		if (phoneDetailService != null) {
			PhoneDetail phoneDetail = new PhoneDetail();
			phoneDetail.setColor("Black");
			phoneDetail.setType("smart");
			phoneDetail.setPhoneId(1);
			phoneDetailService.addDetail(phoneDetail);
			
			PhoneDetail phoneDetail1 = new PhoneDetail();
			phoneDetail1.setColor("Gray");
			phoneDetail1.setType("normal");
			phoneDetail1.setPhoneId(2);
			phoneDetailService.addDetail(phoneDetail1);
			
			PhoneDetail phoneDetail2 = new PhoneDetail();
			phoneDetail2.setColor("White");
			phoneDetail2.setType("smart");
			phoneDetail2.setPhoneId(3);
			phoneDetailService.addDetail(phoneDetail2);
		}
		
	}

}
