package com.example.phones.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.phones.controller.exception.PhoneException;
import com.example.phones.entity.Phone;
import com.example.phones.model.PhoneWrapper;
import com.example.phones.model.Response;
import com.example.phones.service.PhoneService;

/**
 * @author rb611j
 *
 */
@RestController
public class PhoneContoller {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PhoneService phoneService;

	/*
	 * @Autowired private CacheManager cacheManager;
	 */

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "This is Root of my application";
	}

	/**
	 * @return
	 */
	// @pathVariable
	@RequestMapping(value = "/phones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PhoneWrapper> getPhones() {
		logger.info("previous controller method called.");
		List<Phone> phones = phoneService.getPhones();

		PhoneWrapper phoneWrapper = new PhoneWrapper();
		phoneWrapper.setPhoneLst(phones);
		phoneWrapper.setFilterCategory(phoneService.getEquipmentFilters());
		logger.info("Controller after calling service/cache method called.");
		if (phones.isEmpty()) {
			return new ResponseEntity<PhoneWrapper>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PhoneWrapper>(phoneWrapper, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phone/{PhoneId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Phone> getPhoneById(@RequestParam(value = "id")
	// long id) throws PhoneException, Exception {
	public ResponseEntity<Phone> getPhoneById(@PathVariable("PhoneId") Long PhoneId) throws PhoneException, Exception {

		Phone phone = null;
		phone = phoneService.getPhoneById(PhoneId);
		if (phone == null) {
			throw new PhoneException("Phone with this id does not exist");
		} else if (phone.getPhoneName() == "") {
			// throw new Exception("There is some serious issue.");
			throw new Exception("Exception while getting data.");
		}
		return new ResponseEntity<Phone>(phone, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phoneName/{phoneName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// public Phone getPhoneByPhoneName(@RequestParam(value = "name",
	// defaultValue = "Iphone 6") String name) {
	public Phone getPhoneByPhoneName(@PathVariable("phoneName") String phoneName) {
		return phoneService.getPhoneByPhonename(phoneName);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phone/{PhoneId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<Response> deletePhoneById(@RequestParam(value =
	// "id") long id) throws PhoneException {
	public ResponseEntity<Response> deletePhoneById(@PathVariable("PhoneId") Long PhoneId) throws PhoneException {
		try {
			phoneService.deletePhoneById(PhoneId);
		} catch (Exception e) {
			throw new PhoneException("Problem while deleting the phone  " + e.getMessage());
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "phone object has been deleted"),
				HttpStatus.OK);
	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/phone", method = RequestMethod.POST)
	public ResponseEntity<Void> addPhone(@RequestBody Phone phone) {

		/*
		 * if (phoneService.isPhoneExist(phone)) { return new
		 * ResponseEntity<Void>(HttpStatus.CONFLICT); }
		 */
		phoneService.savePhone(phone);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
