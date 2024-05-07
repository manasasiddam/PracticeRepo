package com.ss.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.data.dto.ChildRequestDto;
import com.ss.data.dto.SummaryOfDto;
import com.ss.data.service.DcService;

@RestController
public class ChildrenController {
	
	@Autowired
	private DcService dcService;
	
	
	@PostMapping("/saveChildren")
	public ResponseEntity<SummaryOfDto> saveChildrenData(@RequestBody ChildRequestDto childRequest){
		Long caseNum = dcService.saveChildrenData(childRequest);
		SummaryOfDto summary = dcService.getSummary(caseNum);
		return new ResponseEntity<> (summary, HttpStatus.CREATED);
	}

}
