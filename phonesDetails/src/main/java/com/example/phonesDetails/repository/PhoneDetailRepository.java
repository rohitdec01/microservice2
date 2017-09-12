package com.example.phonesDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.phonesDetails.entity.PhoneDetail;

/**
 * @author Rohit
 *
 */
public interface PhoneDetailRepository extends JpaRepository<PhoneDetail, Integer> {

	/**
	 * @param phoneDetailId
	 * @return
	 */
	public PhoneDetail findPhoneDetailByphoneId(Integer phoneId);
}
