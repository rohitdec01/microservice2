package com.example.micro_phones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_phones.model.Equipment;
import com.example.micro_phones.model.EquipmentDetail;
import com.example.micro_phones.service.EquipmentService;

/**
 * @author Rohit
 *
 */
@RestController
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/mobiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Equipment>> getMobiles() {
		System.out.println("inside equipment controller");
		List<Equipment> mobiles = equipmentService.getMobiles();
		if (mobiles.isEmpty()) {
			return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(mobiles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/equipmentDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public EquipmentDetail getEquipmentDetailByEquipment(@RequestParam(value = "id", defaultValue = "10") long id) {
		return equipmentService.getEquipmentDetailByEquipment(id);
	}

}
