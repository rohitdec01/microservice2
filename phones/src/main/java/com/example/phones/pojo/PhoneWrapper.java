package com.example.phones.pojo;

import java.util.List;

import com.example.phones.model.EquipmentFilter;
import com.example.phones.model.FilterCategory;
import com.example.phones.model.Phone;

/**
 * @author Rohit
 *
 */
public class PhoneWrapper {

	private List<Phone> phoneLst;
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
