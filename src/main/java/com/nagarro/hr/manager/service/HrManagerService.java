package com.nagarro.hr.manager.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.nagarro.hr.manager.model.Employee;

public interface HrManagerService {
	Employee getEmployeeByNameAndCode(String hrName, String code);

	void updateEmployeeByNameAndCode(String hrName, String code, Employee newEmployee);

	void postEmployeesByNameAndFile(String hrName, MultipartFile file);

	void sendXmlToUserByName(String hrName, HttpServletResponse response);

	List<Employee> getAllEmployeesByName(String hrName);
}
