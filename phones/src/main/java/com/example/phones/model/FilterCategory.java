package com.example.phones.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rohit
 *
 */
public class FilterCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer catID;
	private String categoryName;

	private List<EquipmentFilter> equipmentFilters;

	public FilterCategory() {

	}

	public Integer getCatID() {
		return catID;
	}

	public void setCatID(Integer catID) {
		this.catID = catID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<EquipmentFilter> getEquipmentFilters() {
		return equipmentFilters;
	}

	public void setEquipmentFilters(List<EquipmentFilter> equipmentFilters) {
		this.equipmentFilters = equipmentFilters;
	}
}
