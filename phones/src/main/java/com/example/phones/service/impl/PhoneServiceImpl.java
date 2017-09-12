package com.example.phones.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.phones.entity.Phone;
import com.example.phones.intercomm.feignClient.PhoneDetailClient;
import com.example.phones.model.FilterCategory;
import com.example.phones.repository.PhoneRepository;
import com.example.phones.service.PhoneService;

/**
 * @author rb611j
 *
 */
@Service
@CacheConfig(cacheNames = "phones")
public class PhoneServiceImpl implements PhoneService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhoneRepository phoneRepo;
	
	
	/**
	 * This is for Feign Client.  
	 */
	@Autowired
	private PhoneDetailClient phoneDetailClient;

	/**
	 * No-Arg Constructor
	 */
	public PhoneServiceImpl() {

	}

	/**
	 * @param phoneRepo2
	 */
	public PhoneServiceImpl(PhoneRepository phoneRepo) {
		// phoneRepo = phoneRepo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.phones.service.PhoneService#getPhones()
	 */
	@Override
	@Cacheable//(condition = "#instrument.equals('trombone')")
	public List<Phone> getPhones() {
		logger.info("Inside service method called.");
		List<Phone> phones = phoneRepo.findAll();
		getEquipmentFilters();
		return phones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.phones.service.PhoneService#getPhoneById(java.lang.Long)
	 */
	@Override
	public Phone getPhoneById(Long id) throws Exception {
		System.out.println("controller get phone by id");
		Phone phone;
		try {
			phone = phoneRepo.findById(id);
			
			// We need to get phone detail as per the phone from Phone_detail microservice.
			//So I will use Feign client for that.
			phone.setPhoneDetail(phoneDetailClient.getPhoneDetailById(id));
			System.out.println("after getting phone detail from Feign client.");
		} catch (Exception e) {
			throw new Exception();
		}
		
		return phone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.phones.service.PhoneService#savePhone(com.example.phones.
	 * model.Phone)
	 */
	@Override
	public void savePhone(Phone phone) {
		phoneRepo.save(phone);
	}

	@Override
	@Transactional
	public void deletePhoneById(long id) throws Exception {
		// phoneDetailRepo.delete(id);
		try {
			phoneRepo.delete(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Phone getPhoneByPhonename(String phoneName) {
		// TODO Auto-generated method stub
		return phoneRepo.findByphoneName(phoneName);
	}

	@Override
	@CacheEvict(allEntries = true)
	public void clearCache() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.phones.service.PhoneService#getEquipmentFilters()
	 * 
	 * Get filterlist from the filterservice using Rest Template.
	 */
	@Override
	public List<FilterCategory> getEquipmentFilters() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:2022/filters";
 		//FilterCategory filterCategories = restTemplate.getForObject(url, FilterCategory.class);
		@SuppressWarnings("unchecked")
		List<FilterCategory> filterCategories = restTemplate.getForObject(url, List.class);
		
		return filterCategories;
	}


}
