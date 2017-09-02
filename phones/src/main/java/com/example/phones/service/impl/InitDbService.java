package com.example.phones.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phones.model.Phone;
import com.example.phones.repository.PhoneRepository;

/**
 * @author rb611j
 *
 */
@Transactional
@Service
public class InitDbService {

	@Autowired
	PhoneRepository phoneRepository;

	@PostConstruct
	public void init() {
// I am using Builder pattern here. See the setter method approach. (though it is not needed here. :))
		if (phoneRepository != null) {
			Phone phone1 = new Phone();
			phone1.setPhoneName("Iphone 6")
				  .setPhonemanufacturer("Apple"); 
			phoneRepository.save(phone1);

			Phone phone2 = new Phone();
			phone2.setPhoneName("Iphone 7")
				  .setPhonemanufacturer("Apple");
			phoneRepository.save(phone2);

			Phone phone3 = new Phone();
			phone3.setPhoneName("Iphone 8").setPhonemanufacturer("Apple");
			phoneRepository.save(phone3);
		}
	}
}
