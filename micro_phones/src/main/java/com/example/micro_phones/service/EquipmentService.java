package com.example.micro_phones.service;

import com.example.micro_phones.model.EquipmentDetail;
import com.example.micro_phones.model.EquipmentWrapper;

/**
 * @author Rohit
 *
 */
public interface EquipmentService {
	
	/**
	 * @return
	 */
	public EquipmentWrapper getMobiles();
	
	/**
	 * @return
	 */
	public EquipmentDetail getEquipmentDetailByEquipment(Long id);

}
