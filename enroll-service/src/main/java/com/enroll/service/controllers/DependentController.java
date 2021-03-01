package com.enroll.service.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enroll.service.entity.Dependents;
import com.enroll.service.services.DependentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enrollees/")
public class DependentController {
	
	@Autowired
	DependentService dependentService;
	
	@ApiOperation(value = "Save dependents", response = ResponseEntity.class, tags = "Dependents Operations")
	@PostMapping("/{enrollId}/dependents")
	public ResponseEntity<Dependents> createDependents(@Valid @RequestBody Dependents dependents,@PathVariable("enrollId") String enrollId ) {
		dependents = dependentService.saveDependent(dependents,enrollId);
		return ResponseEntity.status(HttpStatus.CREATED).body(dependents);
	}
	@ApiOperation(value = "update dependents", response = ResponseEntity.class, tags = "Dependents Operations")
	@PutMapping("/{enrollId}/dependents")
	public ResponseEntity<Dependents> updateDependents(@Valid @RequestBody Dependents dependents,@PathVariable("enrollId") String enrollId) {
		dependents = dependentService.updateDependent(dependents,enrollId);
		return ResponseEntity.status(HttpStatus.OK).body(dependents);
	}
	@ApiOperation(value = "delete dependents by dependentId", tags = "Dependents Operations")
	@DeleteMapping("/{enrollId}/dependents/{dependentId}")
	public void deleteEnrolleesById(@PathVariable("enrollId") Long enrollId,@PathVariable("dependentId") Long dependentId) {
		dependentService.deleteDependent(enrollId,dependentId);

	}

}
