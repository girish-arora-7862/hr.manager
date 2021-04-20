package com.nagarro.hr.manager.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping(value = { "", "/", "/login" })
	public ModelAndView getLogin(
			@SessionAttribute(value = WebAttributes.AUTHENTICATION_EXCEPTION, required = false) String errorMsg,
			Map<String, Object> model) {
		if (!Objects.isNull(errorMsg) && !errorMsg.isEmpty()) {
			model.put("failureMessage", "Invalid Username/Password");
		}
		return new ModelAndView("login");
	}

}