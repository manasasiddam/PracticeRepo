package com.ss.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.data.Entity.PlanMasterEntity;

public interface PlanMasterEntityRepository extends JpaRepository<PlanMasterEntity, Serializable>{

}
