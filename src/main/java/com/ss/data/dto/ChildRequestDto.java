package com.ss.data.dto;

import java.util.List;

import lombok.Data;


@Data
public class ChildRequestDto {
	
private Long caseNum;
	
	private List<ChildrenDto> childs;

}
