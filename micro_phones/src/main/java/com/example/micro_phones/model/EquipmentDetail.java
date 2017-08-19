package com.example.micro_phones.model;

import java.io.Serializable;

/**
 * @author Rohit
 *
 */
public class EquipmentDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String memory;
	private String size;
	private int equipmentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public EquipmentDetail() {
		// TODO Auto-generated constructor stub
	}

}
