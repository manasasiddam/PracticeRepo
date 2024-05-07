package com.ss.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.data.dto.EducationDto;
import com.ss.data.service.DcService;

@RestController
public class EducationController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/saveEducation")
	public ResponseEntity<Long> saveEducation(EducationDto educationDto) {
		Long caseNumber = dcService.saveEducation(educationDto);

		return new ResponseEntity<>(caseNumber, HttpStatus.CREATED);

	}

}
