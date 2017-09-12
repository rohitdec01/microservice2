package com.example.phonesDetails.service.impl;

import java.util.List;

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
@Transactional
public class PhoneDetailServiceImpl implements PhoneDetailService {

	/**
	 * 
	 */
	@Autowired
	private PhoneDetailRepository phoneDetailRepository;
	
	public PhoneDetailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.example.phonesDetail.service.PhoneDetailService#getPhoneDetailByPhoneId(java.lang.Long)
	 */
	@Override
	public PhoneDetail getPhoneDetailByPhoneId(Integer phoneID) {
		PhoneDetail phoneDetail = phoneDetailRepository.findPhoneDetailByphoneId(phoneID);
		return phoneDetail;
	}

	@Override
	public List<PhoneDetail> getPhoneDetail() {
		List<PhoneDetail> phoneDetails = phoneDetailRepository.findAll();
		return phoneDetails;
	}
	
	/* (non-Javadoc)
	 * @see com.example.phonesDetail.service.PhoneDetailService#addDetail(com.example.phonesDetail.entity.PhoneDetail)
	 */
	@Override
	public void addDetail(PhoneDetail phoneDetail) {
		phoneDetailRepository.save(phoneDetail);
	}

}
