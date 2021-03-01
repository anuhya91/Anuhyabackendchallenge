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

import com.enroll.service.entity.Enrollees;
import com.enroll.service.services.EnrollService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enrollees")
public class EnrolleesController {

	@Autowired
	EnrollService enrollService;

	@ApiOperation(value = "Save enrollees", response = ResponseEntity.class, tags = "Enrollees Operations")
	@PostMapping("/save")
	public ResponseEntity<Enrollees> saveVendor(@Valid @RequestBody Enrollees enrollees) {
		enrollees = enrollService.saveEnrollees(enrollees);
		return ResponseEntity.status(HttpStatus.CREATED).body(enrollees);
	}

	@ApiOperation(value = "update enrollees", response = ResponseEntity.class, tags = "Enrollees Operations")
	@PutMapping("/update")
	public ResponseEntity<Enrollees> updateVendor(@Valid @RequestBody Enrollees enrollees) {

		enrollees = enrollService.updateEnrollees(enrollees);
		return ResponseEntity.status(HttpStatus.OK).body(enrollees);
	}

	@ApiOperation(value = "delete Enrollees by enrollId", tags = "Enrollees Operations")
	@DeleteMapping("/delete/{enrollId}")
	public void deleteEnrolleesById(@PathVariable("enrollId") Long enrollId) {
		enrollService.deleteEnrolleesById(enrollId);

	}

}
