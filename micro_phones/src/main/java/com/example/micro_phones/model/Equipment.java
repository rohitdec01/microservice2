package com.example.micro_phones.model;

import java.io.Serializable;

/**
 * @author Rohit
 *
 */
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String IMEINumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIMEINumber() {
		return IMEINumber;
	}

	public void setIMEINumber(String iMEINumber) {
		IMEINumber = iMEINumber;
	}

	public Equipment() {
		// TODO Auto-generated constructor stub
	}

}
