package com.ss.data.dto;

import java.util.List;

import lombok.Data;

@Data
public class SummaryOfDto {
	
private IncomeDto income;
	
	private EducationDto education;
	
	private List<ChildrenDto> childrens;
	
	private String planName; 

}
