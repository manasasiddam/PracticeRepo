package com.ss.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.data.Entity.IncomeEntity;

public interface IncomeEntityRepository extends JpaRepository<IncomeEntity, Serializable> {

	public IncomeEntity findByCaseNum(Long caseNum);
}
