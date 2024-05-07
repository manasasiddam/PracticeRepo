package com.ss.data.dto;

import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponseDto {
private Long caseNum;
	
	private Map<Integer, String> planNames;

}
