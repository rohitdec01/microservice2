package com.example.micro_phones.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.micro_phones.model.Equipment;
import com.example.micro_phones.model.EquipmentDetail;
import com.example.micro_phones.service.EquipmentService;

/**
 * @author Rohit
 *
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.impl.MobileService#getMobiles()
	 */
	@Override
	public List<Equipment> getMobiles() {
		return equipmentList();
	}

	/**
	 * @return
	 */
	private List<Equipment> equipmentList() {
		List<Equipment> equipments = new ArrayList<Equipment>();

		Equipment equipment = new Equipment();
		equipment.setName("iphone4");
		equipment.setIMEINumber("111111");
		equipments.add(equipment);

		Equipment equipment2 = new Equipment();
		equipment2.setName("iphone5");
		equipment2.setIMEINumber("222222");
		equipments.add(equipment2);

		Equipment equipment3 = new Equipment();
		equipment3.setName("iphone6");
		equipment3.setIMEINumber("3333333");
		equipments.add(equipment3);

		Equipment equipment4 = new Equipment();
		equipment4.setName("iphone7");
		equipment4.setIMEINumber("4444444");
		equipments.add(equipment4);

		return equipments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.micro_phones.service.EquipmentService#
	 * getEquipmentDetailByEquipment(java.lang.Long)
	 */
	@Override
	public EquipmentDetail getEquipmentDetailByEquipment(Long id) {
		return getEquipmentTestData();
	}

	/**
	 * @return
	 */
	private EquipmentDetail getEquipmentTestData() {
		EquipmentDetail equipmentDetail = new EquipmentDetail();
		equipmentDetail.setMemory("64 GB");
		equipmentDetail.setSize("5 Inch");

		return equipmentDetail;
	}

}
