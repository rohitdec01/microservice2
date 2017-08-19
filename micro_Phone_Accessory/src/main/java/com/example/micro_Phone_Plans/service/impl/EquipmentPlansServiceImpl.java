package com.example.micro_Phone_Plans.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import com.example.micro_Phone_Plans.model.EquipmentPlans;
import com.example.micro_Phone_Plans.service.EquipmentPlansService;

/**
 * @author Rohit
 *
 */
@Service
public class EquipmentPlansServiceImpl implements EquipmentPlansService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.micro_Phone_Accessory.service.EquipmentAccessoryService#
	 * getEquipmentAccessory()
	 */
	@Override
	public List<EquipmentPlans> getEquipmentPlans() {
		// TODO Auto-generated method stub
		return getPlansTestData();
	}

	/**
	 * @return
	 */
	private List<EquipmentPlans> getPlansTestData() {

		List<EquipmentPlans> equipmentPlans = new ArrayList<>();

		EquipmentPlans equipmentPlan = new EquipmentPlans();
		equipmentPlan.setPlanID(1);
		equipmentPlan.setPlanName("plan 1");
		equipmentPlans.add(equipmentPlan);

		EquipmentPlans equipmentPlan2 = new EquipmentPlans();
		equipmentPlan2.setPlanID(2);
		equipmentPlan2.setPlanName("plan 2");
		equipmentPlans.add(equipmentPlan2);

		EquipmentPlans equipmentPlan3 = new EquipmentPlans();
		equipmentPlan3.setPlanID(3);
		equipmentPlan3.setPlanName("plan 3");
		equipmentPlans.add(equipmentPlan3);

		return equipmentPlans;
	}

}
