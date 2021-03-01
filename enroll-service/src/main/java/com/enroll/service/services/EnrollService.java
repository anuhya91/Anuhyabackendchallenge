package com.enroll.service.services;

import com.enroll.service.entity.Enrollees;

public interface EnrollService {

	Enrollees getEnrolleesById(long id);

	Enrollees saveEnrollees(Enrollees enrollees);

	Enrollees updateEnrollees(Enrollees enrollees);

	void deleteEnrolleesById(Long enrollId);
}
