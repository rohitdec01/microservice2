package com.example.micro_phoneFilters.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "FILTER_CATEGORY")
public class FilterCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catID;
	private String categoryName;
	
    @OneToMany(targetEntity=EquipmentFilter.class, mappedBy = "filterCategory", 
    		cascade= CascadeType.ALL)
    //@JsonManagedReference
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
