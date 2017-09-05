package com.example.phones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rb611j
 *
 */
@Entity
@Table(name = "PHONE")
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String phoneName;
	private String phonemanufacturer;

	// @JsonInclude(JsonInclude.Include.NON_NULL)
	/**
	 * I am setting this from another service.
	 */
	/*
	 * @JsonInclude()
	 * 
	 * @Transient private EquipmentFilter phoneFiltes;
	 */

	public Phone() {

	}

	public Phone(String phoneName, String phonemanufacturer) {
		this.phoneName = phoneName;
		this.phonemanufacturer = phonemanufacturer;
	}

	// private PhoneDetail phoneDetail;

	/**
	 * @return
	 */
	/*
	 * @OneToOne(cascade = CascadeType.ALL) public PhoneDetail getPhoneDetail()
	 * { return phoneDetail; }
	 * 
	 *//**
		 * @param phoneDetail
		 *//*
		 * public void setPhoneDetail(PhoneDetail phoneDetail) {
		 * this.phoneDetail = phoneDetail; }
		 */

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/*
	 * public EquipmentFilter getPhoneFiltes() { return phoneFiltes; }
	 * 
	 * public void setPhoneFiltes(EquipmentFilter phoneFiltes) {
	 * this.phoneFiltes = phoneFiltes; }
	 */

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	@Column(name = "PHONE_NAME", nullable = false, length = 100)
	public String getPhoneName() {
		return phoneName;
	}

	/**
	 * @param phoneName
	 * 
	 *            I am using builder pattern here Just for fun. Check the return
	 *            statement.
	 */
	public Phone setPhoneName(String phoneName) {
		this.phoneName = phoneName;
		return this;
	}

	/**
	 * @return
	 */
	public String getPhonemanufacturer() {
		return phonemanufacturer;
	}

	/**
	 * @param phonemanufacturer
	 */
	public Phone setPhonemanufacturer(String phonemanufacturer) {
		this.phonemanufacturer = phonemanufacturer;
		return this;
	}
}
