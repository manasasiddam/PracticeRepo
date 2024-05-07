package com.ss.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.data.Entity.CitizenAppEntity;

public interface CitizenAppEntityRepository extends JpaRepository<CitizenAppEntity, Serializable>{

}
