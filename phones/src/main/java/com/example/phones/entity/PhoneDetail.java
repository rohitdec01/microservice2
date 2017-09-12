package com.example.phones.entity;

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
/*@Entity
@Table(name = "PHONE_DETAIL")*/
public class PhoneDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private Long id;
	private String type; // smart, Normal
	private String color;
	
	//@OneToOne(mappedBy = "phoneDetail")
	private Long phoneId;

	public PhoneDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PhoneDetailID")*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	
}
