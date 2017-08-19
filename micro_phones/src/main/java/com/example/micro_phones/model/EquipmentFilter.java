package com.example.micro_phones.model;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rohit
 *
 */
public class EquipmentFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Map<String, String> type; // Smart, Normal
	private Map<String, String> brand; // Sumsung, Apple

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getType() {
		return type;
	}

	public void setType(Map<String, String> type) {
		this.type = type;
	}

	public Map<String, String> getBrand() {
		return brand;
	}

	public void setBrand(Map<String, String> brand) {
		this.brand = brand;
	}

}
