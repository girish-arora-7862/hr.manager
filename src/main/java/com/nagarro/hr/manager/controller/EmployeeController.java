package com.nagarro.hr.manager.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hr.manager.model.Employee;
import com.nagarro.hr.manager.service.HrManagerService;

@Controller
public class EmployeeController {

	private final HrManagerService hrManagerService;

	public EmployeeController(HrManagerService hrManagerService) {
		this.hrManagerService = hrManagerService;
	}

	@RequestMapping(value = "/employee/{code}", method = RequestMethod.GET)
	public ModelAndView getEmplyeeEdit(@PathVariable String code, Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Employee employee = hrManagerService.getEmployeeByNameAndCode(username, code);
		model.put("employee", employee);
		model.put("username", username);
		return new ModelAndView("employeeEdit", model);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ModelAndView postEmplyeeEdit(@ModelAttribute("employee") Employee employee, Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		hrManagerService.updateEmployeeByNameAndCode(username, String.valueOf(employee.getCode()), employee);
		return new ModelAndView("redirect:/home", model);
	}

}
