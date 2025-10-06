package com.utmost.module.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = "/xdm/Login")
	public String login() {

		return "xdm/login/Login"; 
	}

}
