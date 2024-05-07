package com.ss.data.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ss.data.dto.CreateCaseResponseDto;
import com.ss.data.service.DcService;

@RestController
public class CreateCaseResponseController {
	@Autowired
	private DcService dcService;
	
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<Long> createCaseNum(Integer appId){
		Long loadCaseNumber = dcService.loadCaseNum(appId);
		
		 Map<Integer, String> planMap=dcService.getPlanNames();
		 CreateCaseResponseDto createCaseResponse= new CreateCaseResponseDto();
		 createCaseResponse.setCaseNum(loadCaseNumber);
		 createCaseResponse.setPlanNames(planMap);
		 
		return new ResponseEntity<>(loadCaseNumber,HttpStatus.CREATED);
		
	}

}
