package com.ss.data.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenAppDto {
	
	private String fullName;
	
	private String email;
	
	private Long mobileNumber;
	
	private String gender;
	
	private Long ssn;
	
	private String stateName;
	
	private LocalDate dateOfBirth;

}
