package com.nagarro.hr.manager.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.hr.manager.model.Employee;
import com.nagarro.hr.manager.util.ExcelExporter;
import com.nagarro.hr.manager.util.ExcelHelper;

@Service
public class HrManagerServiceImpl implements HrManagerService {

	@Value("${api.base.url}")
	private String baseUrl;
	
	private final RestTemplate restTemplate;
	
	public HrManagerServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Employee getEmployeeByNameAndCode(String hrName, String code) {
		Employee employee = null;
		try {
			String url = baseUrl + "/hr/{hrName}/employee/{code}";
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("hrName", hrName);
			vars.put("code", code);
			employee = restTemplate.getForObject(url, Employee.class, vars);
		} catch (Exception e) {
			// Do Nothing
		}
		return employee;
	}

	@Override
	public void updateEmployeeByNameAndCode(String hrName, String code, Employee newEmployee) {
		try {
			String url = baseUrl + "/hr/{username}/employee/{code}";
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("username", hrName);
			vars.put("code", String.valueOf(newEmployee.getCode()));
			restTemplate.put(url, newEmployee, vars);
		} catch (Exception e) {
			// Do Nothing
		}
	}

	@Override
	public void postEmployeesByNameAndFile(String hrName, MultipartFile file) {
		try {
			List<Employee> employees = new ArrayList<>();
			if (ExcelHelper.hasExcelFormat(file)) {
				employees = ExcelHelper.excelToEmployees(file.getInputStream());
			}
			String url = baseUrl + "/hr/{hrName}/employees";
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("hrName", hrName);
			restTemplate.postForObject(url, employees, Object.class, vars);
		} catch (Exception e) {
			/// Do Nothing
		}
	}

	@Override
	public void sendXmlToUserByName(String hrName, HttpServletResponse response) {
		try {
			String url = baseUrl + "/hr/{hrName}/employee";
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("hrName", hrName);
			ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Employee>>() {
					}, vars);
			List<Employee> employees = responseEntity.getBody();

			response.setContentType("application/octet-stream");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=employees_" + currentDateTime + ".xlsx";
			response.setHeader(headerKey, headerValue);

			ExcelExporter excelExporter = new ExcelExporter(employees);

			excelExporter.export(response);
		} catch (Exception e) {
			/// Do Nothing
		}
	}

	@Override
	public List<Employee> getAllEmployeesByName(String hrName) {
		List<Employee> employees = new ArrayList<>();
		try {
			String url = baseUrl + "/hr/{hrName}/employee";
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("hrName", hrName);

			ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Employee>>() {
					}, vars);
			employees = responseEntity.getBody();
		} catch (Exception e) {
			// Do Nothing
		}
		return employees;
	}

}
