package com.example.micro_phoneFilters.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.micro_phoneFilters.entity.EquipmentFilter;
import com.example.micro_phoneFilters.entity.FilterCategory;
import com.example.micro_phoneFilters.repository.EquipmentFilterRepository;
import com.example.micro_phoneFilters.repository.FilterCategoryRepository;

/**
 * @author rb611j
 *
 */
@Transactional
@Service
public class InitDbService {

	@Autowired
	private FilterCategoryRepository filterCategoryRepo;
	
	@Autowired
	private EquipmentFilterRepository equipmentFilterRepo;

	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		if (filterCategoryRepo != null) {
			addFilter_category();
			addFilter(1,null);
			addFilter2(2,null);
		}
	}
	
	/**
	 * Save multiple filters 
	 */
	/* (non-Javadoc)
	 * @see com.example.micro_phoneFilters.service.EquipmentFilterService#addFilter_category()
	 */
	private void addFilter_category() {
		//filterCategoryRepo.save(addBrandCategory());
		//filterCategoryRepo.save(addTypeCategory());
		FilterCategory filterCategory = new FilterCategory();
		filterCategory.setCategoryName("Brand");
		filterCategoryRepo.save(filterCategory);
		
		FilterCategory filterCategory2 = new FilterCategory();
		filterCategory2.setCategoryName("Type");
		filterCategoryRepo.save(filterCategory2);
	}
	
	/**
	 * @param catId
	 * @param equipmentFilter1
	 */
	private void addFilter(Integer catId, EquipmentFilter equipmentFilter1) {
		FilterCategory filterCategory = filterCategoryRepo.findByCatID(catId);
		
		EquipmentFilter equipmentFilter = new EquipmentFilter();
		equipmentFilter.setFilterName("Sansung");
		equipmentFilter.setFilterCategory(filterCategory);
		equipmentFilterRepo.save(equipmentFilter);
		
		EquipmentFilter equipmentFilter2 = new EquipmentFilter();
		equipmentFilter2.setFilterName("Apple");
		equipmentFilter2.setFilterCategory(filterCategory);
		equipmentFilterRepo.save(equipmentFilter2);
	}
	
	/**
	 * @param catId
	 * @param equipmentFilter1
	 */
	private void addFilter2(Integer catId, EquipmentFilter equipmentFilter1) {
		FilterCategory filterCategory = filterCategoryRepo.findByCatID(catId);
		
		EquipmentFilter equipmentFilter = new EquipmentFilter();
		equipmentFilter.setFilterName("Smart");
		equipmentFilter.setFilterCategory(filterCategory);
		equipmentFilterRepo.save(equipmentFilter);
		
		
		EquipmentFilter equipmentFilter2 = new EquipmentFilter();
		equipmentFilter2.setFilterName("Normal");
		equipmentFilter2.setFilterCategory(filterCategory);
		equipmentFilterRepo.save(equipmentFilter2);
	}
	
}
