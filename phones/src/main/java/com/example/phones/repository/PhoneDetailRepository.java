package com.example.phones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.phones.model.PhoneDetail;

/**
 * @author rb611j
 *
 */
public interface PhoneDetailRepository extends JpaRepository<PhoneDetail, Long> {

	/**
	 * @return
	 */
	//public PhoneDetail getPhoneDetailByPhoneId(Long id);
}
