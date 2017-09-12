package com.example.phonesDetails.service;

import java.util.List;

import com.example.phonesDetails.entity.PhoneDetail;

/**
 * @author Rohit
 *
 */
public interface PhoneDetailService {
	
	/**
	 * @param phoneDetailID
	 * @return
	 */
	public PhoneDetail getPhoneDetailByPhoneId(Integer phoneID);
	
	/**
	 * @return
	 */
	public List<PhoneDetail> getPhoneDetail();
	
	
	/**
	 * @param phoneDetail
	 */
	public void addDetail(PhoneDetail phoneDetail);
}
