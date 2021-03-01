package com.enroll.service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enroll.service.entity.Dependents;
import com.enroll.service.entity.Enrollees;
import com.enroll.service.exceptions.ResourceNotFoundException;
import com.enroll.service.repository.DependentsRespository;
import com.enroll.service.repository.EnrolleesRepository;

@Service
public class DependentServiceImpl implements DependentService {

	@Autowired
	DependentsRespository dependentsRespository;
	@Autowired
	EnrolleesRepository enrolleesRepository;

	@Override
	public Dependents saveDependent(Dependents dependents, String enrollId) {

		Optional<Enrollees> enrolleesExists = Optional
				.ofNullable(enrolleesRepository.findByEnrollId(Long.valueOf(enrollId)));
		if (!enrolleesExists.isPresent()) {
			throw new ResourceNotFoundException("enroll Id " + enrollId + " not found");

		}
		dependents.setEnrollees(enrolleesExists.get());
		return dependentsRespository.save(dependents);

	}

	@Override
	public Dependents updateDependent(Dependents dependents, String enrollId) {

		Optional<Enrollees> enrolleesExists = Optional
				.ofNullable(enrolleesRepository.findByEnrollId(Long.valueOf(enrollId)));
		if (!enrolleesExists.isPresent()) {
			throw new ResourceNotFoundException("enrollees Id " + enrollId + " not found");

		}
		Dependents loadedDependents = dependentsRespository.findByDependentId(dependents.getDependentId());
		if (loadedDependents == null) {
			throw new ResourceNotFoundException("dependent Id " + dependents.getDependentId() + " not found");
		}
		loadedDependents.setDependentBirthDate(dependents.getDependentBirthDate());
		loadedDependents.setDependentName(dependents.getDependentName());
		return dependentsRespository.save(loadedDependents);
	}

	@Override
	public void deleteDependent(Long enrollId, Long dependentId) {
		Optional<Enrollees> enrolleesExists = Optional.ofNullable(enrolleesRepository.findByEnrollId(enrollId));
		if (!enrolleesExists.isPresent()) {
			throw new ResourceNotFoundException("enrollees Id " + enrollId + " not found");

		}
		Dependents loadedDependents = dependentsRespository.findByDependentId(dependentId);
		if (loadedDependents == null) {
			throw new ResourceNotFoundException("dependent Id " + dependentId + " not found");
		}
		dependentsRespository.delete(loadedDependents);
	}

}
