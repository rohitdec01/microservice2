package com.example.phones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.phones.entity.Phone;

/**
 * @author rb611j
 *
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	/**
	 * @param id
	 * @return
	 */
	public Phone findById(Long id);
	
	/**
	 * @param phoneName
	 * @return
	 */
	public Phone findByphoneName(String phoneName);
}
