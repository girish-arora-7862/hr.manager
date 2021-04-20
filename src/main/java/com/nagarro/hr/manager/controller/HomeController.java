package com.nagarro.hr.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hr.manager.model.Employee;
import com.nagarro.hr.manager.service.HrManagerService;

@Controller
public class HomeController {

	private final HrManagerService hrManagerService;

	public HomeController(HrManagerService hrManagerService) {
		this.hrManagerService = hrManagerService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome(Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		List<Employee> employees = hrManagerService.getAllEmployeesByName(username);
		model.put("username", username);
		model.put("employees", employees);
		return new ModelAndView("home", model);
	}

}
