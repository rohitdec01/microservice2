package com.example.micro_Phone_Plans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.micro_Phone_Plans.model.EquipmentPlans;
import com.example.micro_Phone_Plans.service.EquipmentPlansService;

@Controller
public class EquipmentPlansController {

	@Autowired
	private EquipmentPlansService equipmentPlansService;

	@RequestMapping(value = "/plans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EquipmentPlans>> getEquipmentPlans() {
		System.out.println("inside Filter controller");
		List<EquipmentPlans> equipmentPlans = equipmentPlansService.getEquipmentPlans();
		if (equipmentPlans == null) {
			return new ResponseEntity<List<EquipmentPlans>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EquipmentPlans>>(equipmentPlans, HttpStatus.OK);
	}

}
