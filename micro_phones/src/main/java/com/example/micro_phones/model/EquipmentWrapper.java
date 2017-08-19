package com.example.micro_phones.model;

import java.util.List;

/**
 * @author Rohit
 *
 */
public class EquipmentWrapper {

	private List<Equipment> equipmentLst;
	private EquipmentFilter equipmentFilters;

	public List<Equipment> getEquipmentLst() {
		return equipmentLst;
	}

	public void setEquipmentLst(List<Equipment> equipmentLst) {
		this.equipmentLst = equipmentLst;
	}

	public EquipmentFilter getEquipmentFilters() {
		return equipmentFilters;
	}

	public void setEquipmentFilters(EquipmentFilter equipmentFilters) {
		this.equipmentFilters = equipmentFilters;
	}
}
