package com.greatlearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
	@Override
	public GreatLearning get() {
		log.info("Inside get() method ");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Learn Controller in Spring boot");
		greatLearning.setCourseType("Information Technology");
		greatLearning.setInstructurName(FullName.builder().FirstName("K Akhil").LastName("Sai").build());
		//greatLearning.setInstructurName("K Akhil Sai");
		return greatLearning;

	}
	@Override
	public GreatLearning custominfo(String courseName, String couresType, String FirstName, String LastName) {
		log.info("Inside custominfo() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(couresType);
		greatLearning.setInstructurName(FullName.builder().FirstName("K Akhil").LastName("Sai").build());
		//greatLearning.setInstructurName(instructorName);
		return greatLearning;

	}

}
