package com.example.phones.model;

import java.io.Serializable;

/**
 * @author Rohit
 *
 */
public class EquipmentFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer filterID;
	private String filterName;
		
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

}