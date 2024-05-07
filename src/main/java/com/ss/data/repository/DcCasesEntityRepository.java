package com.ss.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.data.Entity.DcCasesEntity;

public interface DcCasesEntityRepository extends JpaRepository<DcCasesEntity, Serializable>{

}
