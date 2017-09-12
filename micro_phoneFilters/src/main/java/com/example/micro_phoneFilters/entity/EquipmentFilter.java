package com.example.micro_phoneFilters.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Rohit
 *
 */
@Entity
@Table(name = "EQUIPMENT_FILTER")
public class EquipmentFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer filterID;
	private String filterName;
		
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filterCat_fk")
	@JsonBackReference
	private FilterCategory filterCategory;
	
	public Integer getFilterID() {
		return filterID;
	}

	public void setFilterID(Integer filterID) {
		this.filterID = filterID;
	}

	public EquipmentFilter() {

	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public FilterCategory getFilterCategory() {
		return filterCategory;
	}

	public void setFilterCategory(FilterCategory filterCategory) {
		this.filterCategory = filterCategory;
	}

}