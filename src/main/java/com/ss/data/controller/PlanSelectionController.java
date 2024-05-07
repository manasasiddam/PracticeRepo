package com.ss.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.data.dto.PlanSelectionDto;
import com.ss.data.service.DcService;

@RestController
public class PlanSelectionController {

	@Autowired
	private DcService dcService;

	@PostMapping("/planSelection")
	public ResponseEntity<Long> savePlanSelection(@RequestBody PlanSelectionDto planSelectionDto) {

		Long caseNumber = dcService.savePlanSelection(planSelectionDto);

		return new ResponseEntity<>(caseNumber, HttpStatus.CREATED);

	}

}
