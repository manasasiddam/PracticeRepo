package com.ss.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.data.Entity.EducationEntity;

public interface EducationEntityRepository extends JpaRepository<EducationEntity, Serializable> {

	public EducationEntity findByCaseNum(Long caseNum);


	
}
