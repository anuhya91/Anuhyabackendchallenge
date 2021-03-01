package com.enroll.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enroll.service.entity.Dependents;

public interface DependentsRespository extends JpaRepository<Dependents, Long> {

	Dependents findByDependentId(Long dependentId);
}
