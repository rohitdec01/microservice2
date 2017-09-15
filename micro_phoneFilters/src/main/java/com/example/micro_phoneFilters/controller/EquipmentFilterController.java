package com.example.micro_phoneFilters.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.micro_phoneFilters.entity.FilterCategory;
import com.example.micro_phoneFilters.service.EquipmentFilterService;

/**
 * @author Rohit
 *
 */
@RestController
@RequestMapping("/*")
public class EquipmentFilterController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EquipmentFilterService equipmentFilterService;

	/**
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "This is Root of Equipment Filter";
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "filters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FilterCategory>> getFilters() {
		System.out.println("inside Filter controller");
		List<FilterCategory> equipmentFilters = equipmentFilterService.getEquipmentFilters();
		if (equipmentFilters == null) {
			return new ResponseEntity<List<FilterCategory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilterCategory>>(equipmentFilters, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/filters2", method = RequestMethod.GET, produces
	 * = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<List<EquipmentFilter>> getFilters2() { System.out.println(
	 * "inside Filter controller"); List<EquipmentFilter> equipmentFilters =
	 * equipmentFilterService.getEquipmentFilters2(); if (equipmentFilters ==
	 * null) { return new
	 * ResponseEntity<List<EquipmentFilter>>(HttpStatus.NO_CONTENT); } return
	 * new ResponseEntity<List<EquipmentFilter>>(equipmentFilters,
	 * HttpStatus.OK); }
	 */

}
