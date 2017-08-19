package com.example.micro_phones.service;

import java.util.List;

import com.example.micro_phones.model.Equipment;
import com.example.micro_phones.model.EquipmentDetail;

/**
 * @author Rohit
 *
 */
public interface EquipmentService {
	
	/**
	 * @return
	 */
	public List<Equipment> getMobiles();
	
	/**
	 * @return
	 */
	public EquipmentDetail getEquipmentDetailByEquipment(Long id);

}
