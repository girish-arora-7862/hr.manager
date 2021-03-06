package com.nagarro.hr.manager.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hr.manager.service.HrManagerService;

@Controller
public class ExcelController {

	private final HrManagerService hrManagerService;

	public ExcelController(HrManagerService hrManagerService) {
		this.hrManagerService = hrManagerService;
	}

	@RequestMapping(value = "/excel", method = RequestMethod.POST)
	public ModelAndView postExcel(@RequestParam("file") MultipartFile file, Map<String, Object> model)
			throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		hrManagerService.postEmployeesByNameAndFile(username, file);
		return new ModelAndView("redirect:/home", model);
	}

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public void getExcel(HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		hrManagerService.sendXmlToUserByName(username, response);
	}
}
