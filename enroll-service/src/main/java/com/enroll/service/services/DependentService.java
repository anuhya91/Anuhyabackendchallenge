package com.enroll.service.services;

import com.enroll.service.entity.Dependents;

public interface DependentService {

	Dependents saveDependent(Dependents dependents, String enrollId);

	Dependents updateDependent(Dependents dependents, String enrollId);

	void deleteDependent(Long enrollId, Long dependentId);

}
