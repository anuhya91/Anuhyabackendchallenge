package com.enroll.service.controller;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.enroll.service.entity.Enrollees;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class) 	 	
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EnrollControllerTest {
	
	private static final String SAVE_ENROLLEES  = "/enrollees/save";
	private static final String UPDATE_ENROLLEES  = "/enrollees/update";
	private static final String DELETE_ENROLLEES  = "/enrollees/delete/{enrollId}";

	private ObjectMapper mapper;
	
	private Enrollees enrollees;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setup() throws JsonParseException, JsonMappingException, IOException
	{
		ClassLoader classLoader = new EnrollControllerTest().getClass().getClassLoader();
		File file = new File(classLoader.getResource("enrollees.json").getFile());
		mapper = new ObjectMapper();
		enrollees = mapper.readValue(file, Enrollees.class);
	} 
	
	
	@Test
	public void testSaveEnrollees()
	{
		Enrollees enrollees1 = restTemplate.postForEntity(SAVE_ENROLLEES, enrollees, Enrollees.class).getBody();
		assertNotNull(enrollees1); 
	}
	
	@Test
	public void testUpdateEnrollees() throws URISyntaxException
	{
 
		restTemplate.put(UPDATE_ENROLLEES, enrollees); 
	}
	
	@Test
	public void testDeleteBusinessProcess() {
		Long enrollId = 10L;
		restTemplate.delete(DELETE_ENROLLEES, enrollId);
	}
}
