	package com.example.phones.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.phones.controller.exception.PhoneException;
import com.example.phones.model.Phone;
import com.example.phones.model.Response;
import com.example.phones.pojo.PhoneWrapper;
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
	
	@Autowired
    private CacheManager cacheManager;
	
	/**
	 * @return
	 */
	@RequestMapping("/")
    public String index(){
        return "This is Root of my application";
    }

	/**
	 * @return
	 */
	@RequestMapping(value = "/phones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PhoneWrapper> getPhones() {
		logger.info("previous controller method called.");
		List<Phone> phones = phoneService.getPhones();
		
		PhoneWrapper phoneWrapper  = new PhoneWrapper();
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
	@RequestMapping(value = "/phone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Phone> getPhoneById(@RequestParam(value = "id") long id)  throws PhoneException, Exception {
		
		Phone phone = null;
		phone = phoneService.getPhoneById(id);
		if (phone == null) {
			throw new PhoneException("Phone with this id does not exist");
		} else if (phone.getPhoneName() == "") {
			//throw new Exception("There is some serious issue.");
			throw new Exception();
		}
		return new ResponseEntity<Phone>(phone, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phoneName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone getPhoneByPhoneName(@RequestParam(value = "name", defaultValue = "Iphone 6") String name) {
		return phoneService.getPhoneByPhonename(name);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phone", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deletePhoneById(@RequestParam(value = "id") long id) throws PhoneException {
		try {
			phoneService.deletePhoneById(id);
		} catch (Exception e) {
			throw new PhoneException ("Problem while deleting the phone  " + e.getMessage());
		}
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "phone object has been deleted"), HttpStatus.OK);
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

	/******************************************************************************************************************
	*******************************************************************************************************************
	*******************************************************************************************************************/

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/phoneDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone getPhoneDetailById(@RequestParam(value = "id", defaultValue = "10") long id) {
			//return phoneService.getPhoneById(id);
		return null;
	}
	
	
	// Used in case of payload and 
	/*@RequestMapping(value = "/phone", method = RequestMethod.POST)
   	public ResponseEntity<Phone> saveToDo(@RequestBody Phone payload) throws PhoneException{
    	logger.info("Payload to save " + payload);
    	
	}*/
	
	 /*@RequestMapping(value = "/phone/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Response> removeToDoById(@PathVariable("id") long id) throws PhoneException{
		 
	 }*/

}
