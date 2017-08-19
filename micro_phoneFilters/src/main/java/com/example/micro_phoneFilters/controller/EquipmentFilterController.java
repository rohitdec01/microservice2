package com.example.micro_phoneFilters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_phoneFilters.model.EquipmentFilter;
import com.example.micro_phoneFilters.service.EquipmentFilterService;

@RestController
public class EquipmentFilterController {
	
	@Autowired
	private EquipmentFilterService equipmentFilterService;

	@RequestMapping(value = "/filters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EquipmentFilter> getFilters() {
		System.out.println("inside Filter controller");
		EquipmentFilter equipmentFilters = equipmentFilterService.getEquipmentFilters();
		if (equipmentFilters == null) {
			return new ResponseEntity<EquipmentFilter>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EquipmentFilter>(equipmentFilters, HttpStatus.OK);
	}
}
