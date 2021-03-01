package com.enroll.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enroll.service.entity.Enrollees;

public interface EnrolleesRepository extends JpaRepository<Enrollees, Long> {

	Enrollees findByEnrollId(Long id);
}
