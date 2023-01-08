package com.greatlearning.library.service;

import com.greatlearning.library.model.GreatLearning;


public interface ExampleService {

	// @ResponseBody
	GreatLearning get();

	GreatLearning custominfo(String courseName, String couresType, String FirstName, String LastName);

}