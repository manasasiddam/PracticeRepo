package com.ss.data.service;

import java.util.Map;

import com.ss.data.dto.ChildRequestDto;
import com.ss.data.dto.EducationDto;
import com.ss.data.dto.IncomeDto;
import com.ss.data.dto.PlanSelectionDto;
import com.ss.data.dto.SummaryOfDto;

public interface DcService {

public Long loadCaseNum(Integer appId);
	
	public Map<Integer, String> getPlanNames();
	
	public Long savePlanSelection (PlanSelectionDto planSelectionDto);
	
	public Long saveIncomeData(IncomeDto incomeDto);
	
	public Long saveEducation(EducationDto enducationDto);
	
	public Long saveChildrenData(ChildRequestDto childRequest);
	
	public SummaryOfDto getSummary(Long caseNum);
}


