package com.example.phones.service;

import java.util.List;

import com.example.phones.entity.Phone;
import com.example.phones.model.FilterCategory;

/**
 * @author rb611j
 *
 */
public interface PhoneService {

	/**
	 * @return
	 */
	public List<Phone> getPhones();

	/**
	 * @param id
	 * @return
	 */
	public Phone getPhoneById(Long id) throws Exception;

	/**
	 * @param phoneName
	 * @return
	 */
	public Phone getPhoneByPhonename(String phoneName);

	/**
	 * @param phone
	 */
	public void savePhone(Phone phone);

	/**
	 * @param id
	 * @return
	 */
	public void deletePhoneById(long id) throws Exception;

	/**
	 * 
	 */
	public void clearCache();

	/**
	 * @return
	 */
	public List<FilterCategory> getEquipmentFilters();

}
