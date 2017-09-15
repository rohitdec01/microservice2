package com.example.phonesDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.phonesDetails.entity.PhoneDetail;
import com.example.phonesDetails.service.PhoneDetailService;

/**
 * @author Rohit
 *
 */
@RestController
@RequestMapping("/*")
public class PhoneDetailController {

	/**
	 * 
	 */
	@Autowired
	private PhoneDetailService phoneDetailService;

	public PhoneDetailController() {
		// TODO Auto-generated constructor stub
	}

	// @pathVariable
	@RequestMapping(value = "phonesDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PhoneDetail>> getPhoneDetails() {
		List<PhoneDetail> phonesDetail = phoneDetailService.getPhoneDetail();

		return new ResponseEntity<List<PhoneDetail>>(phonesDetail, HttpStatus.OK);
	}

	/**
	 * @param phoneId
	 * @return
	 */
	@RequestMapping(value = "phone/{phoneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Response> PhoneById(@RequestParam(value =
	// "id") long id) throws PhoneException {
	public ResponseEntity<PhoneDetail> getPhoneDetailById(@PathVariable("phoneId") Integer phoneId) {
		PhoneDetail phoneDetail = phoneDetailService.getPhoneDetailByPhoneId(phoneId);

		return new ResponseEntity<PhoneDetail>(phoneDetail, HttpStatus.OK);
	}

}
