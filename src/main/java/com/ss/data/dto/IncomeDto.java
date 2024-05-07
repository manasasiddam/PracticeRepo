package com.ss.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {
	
	private Long caseNum;
	
	private Double empIncome;
	
	private Double propertyIncome;
	
	private Double rentIncome;

}
