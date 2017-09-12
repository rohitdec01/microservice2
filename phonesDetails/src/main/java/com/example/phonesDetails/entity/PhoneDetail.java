package com.example.phonesDetails.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rb611j
 *
 */
@Entity
@Table(name = "PHONE_DETAIL")
public class PhoneDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type; // smart, Normal
	private String color;
	
	//@OneToOne(mappedBy = "phoneDetail")
	private Integer phoneId;

	public PhoneDetail() {

	}

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PhoneDetailID")*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	
}
