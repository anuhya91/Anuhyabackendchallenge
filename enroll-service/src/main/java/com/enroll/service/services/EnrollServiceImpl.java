package com.enroll.service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enroll.service.entity.Enrollees;
import com.enroll.service.exceptions.ResourceAlreadyExist;
import com.enroll.service.exceptions.ResourceNotFoundException;
import com.enroll.service.repository.EnrolleesRepository;

@Service
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	EnrolleesRepository enrolleesRepository;

	@Override
	public Enrollees getEnrolleesById(long id) {
		// TODO Auto-generated method stub
		return enrolleesRepository.findByEnrollId(id);
	}

	@Override
	public Enrollees saveEnrollees(Enrollees enrollees) {

		Optional<Enrollees> enrolleesExists = Optional
				.ofNullable(enrolleesRepository.findByEnrollId(enrollees.getEnrollId()));

		if (enrolleesExists.isPresent()) {
			throw new ResourceAlreadyExist("Enrollees alreday exist");
		}
		return enrolleesRepository.save(enrollees);
	}

	@Override
	public Enrollees updateEnrollees(Enrollees enrollees) {
		Optional<Enrollees> enrolleesExists = Optional
				.ofNullable(enrolleesRepository.findByEnrollId(enrollees.getEnrollId()));
		if (!enrolleesExists.isPresent()) {
			throw new ResourceNotFoundException(" resource not found");
		}
		return enrolleesRepository.save(enrollees);

	}

	@Override
	public void deleteEnrolleesById(Long enrollId) {
		enrolleesRepository.deleteById(enrollId);

	}

}
