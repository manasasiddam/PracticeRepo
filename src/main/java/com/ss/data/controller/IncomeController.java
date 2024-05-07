package com.ss.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.data.dto.IncomeDto;
import com.ss.data.service.DcService;

@RestController
public class IncomeController {

	@Autowired
	private DcService dcService;

	@PostMapping("/saveIncome")
	public ResponseEntity<Long> saveIncomeData(IncomeDto incomeDto) {

		Long CaseNumber = dcService.saveIncomeData(incomeDto);

		return new ResponseEntity<>(CaseNumber, HttpStatus.CREATED);

	}

}
