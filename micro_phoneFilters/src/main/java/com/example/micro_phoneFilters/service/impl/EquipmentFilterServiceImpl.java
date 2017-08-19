package com.example.micro_phoneFilters.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.micro_phoneFilters.model.EquipmentFilter;
import com.example.micro_phoneFilters.service.EquipmentFilterService;

/**
 * @author Rohit
 *
 */
@Service
public class EquipmentFilterServiceImpl implements EquipmentFilterService {

	@Override
	public EquipmentFilter getEquipmentFilters() {

		return getEquipmentFilterTest();
	}

	private EquipmentFilter getEquipmentFilterTest() {
		EquipmentFilter equipmentFilters = new EquipmentFilter();

		Map<String, String> typeList = new HashMap<>();
		typeList.put("smart", "Smart Phones");
		typeList.put("normal", "Normal Phones");
		equipmentFilters.setType(typeList);

		Map<String, String> brandList = new HashMap<>();
		brandList.put("apple", "Apple");
		brandList.put("samgsung", "Samsung");
		equipmentFilters.setBrand(brandList);

		return equipmentFilters;
	}

}
