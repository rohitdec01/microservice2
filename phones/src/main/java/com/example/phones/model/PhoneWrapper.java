package com.example.phones.model;

import java.util.List;

import com.example.phones.entity.Phone;

/**
 * @author Rohit
 *
 */
public class PhoneWrapper {

	private List<com.example.phones.entity.Phone> phoneLst;
	private List<FilterCategory> filterCategory;

	public PhoneWrapper() {
		// TODO Auto-generated constructor stub
	}

	public List<FilterCategory> getFilterCategory() {
		return filterCategory;
	}

	public void setFilterCategory(List<FilterCategory> filterCategory) {
		this.filterCategory = filterCategory;
	}

	public List<Phone> getPhoneLst() {
		return phoneLst;
	}

	public void setPhoneLst(List<Phone> phoneLst) {
		this.phoneLst = phoneLst;
	}

}
