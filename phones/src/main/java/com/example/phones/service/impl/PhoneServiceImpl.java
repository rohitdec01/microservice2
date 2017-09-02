package com.example.phones.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phones.controller.exception.PhoneException;
import com.example.phones.model.Phone;
import com.example.phones.model.PhoneDetail;
import com.example.phones.repository.PhoneDetailRepository;
import com.example.phones.repository.PhoneRepository;
import com.example.phones.service.PhoneService;

/**
 * @author rb611j
 *
 */
@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository phoneRepo;
	@Autowired
	private PhoneDetailRepository phoneDetailRepo;

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
	public List<Phone> getPhones() {
		List<Phone> phones = phoneRepo.findAll();
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
		} catch (Exception e) {
			throw new Exception();
		}
		
		return phone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.phones.service.PhoneService#getPhoneDetailById(java.lang.
	 * Long)
	 */
	@Override
	public PhoneDetail getPhoneDetailById(Long id) {
		PhoneDetail phoneDetail = null;// phoneDetailRepo.getPhoneDetailByPhoneId(id);
		return phoneDetail;
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

}
