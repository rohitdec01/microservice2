package com.example.micro_phoneFilters.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_phoneFilters.entity.FilterCategory;
import com.example.micro_phoneFilters.repository.EquipmentFilterRepository;
import com.example.micro_phoneFilters.repository.FilterCategoryRepository;
import com.example.micro_phoneFilters.service.EquipmentFilterService;

/**
 * @author Rohit
 *
 */
@Service
@Transactional
public class EquipmentFilterServiceImpl implements EquipmentFilterService {
	
	@Autowired
	private FilterCategoryRepository filterCategoryRepo;
	
	@Autowired
	private EquipmentFilterRepository equipmentFilterRepo;

	/* (non-Javadoc)
	 * @see com.example.micro_phoneFilters.service.EquipmentFilterService#getEquipmentFilters()
	 * 
	 * This is not working as per my expectation. It is not returning child object.(list of filter based on the category)
	 */
	@Override
	public List<FilterCategory> getEquipmentFilters() {
		List<FilterCategory> filterCategory = filterCategoryRepo.findAll();
		return filterCategory;
	}
	
	/*@Override
	public List<EquipmentFilter> getEquipmentFilters2() {
		List<EquipmentFilter> filters = equipmentFilterRepo.findAll();
		return filters;
	}*/
	
}
