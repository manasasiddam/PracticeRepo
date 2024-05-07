package com.ss.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	private Long caseNum;
	
	private String highestQualification;
	
	private Integer graduationYear;
	
	private String university;
	

}
