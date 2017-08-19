package com.example.micro_Phone_Plans.model;

import java.io.Serializable;

/**
 * @author Rohit
 *
 */
public class EquipmentPlans implements Serializable {

	private static final long serialVersionUID = 1L;
	private int planID;
	private String planName;

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

}
