package com.cosmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("signin")
	public String showSignIn()
	{
		return "SignIn";
	}
	
	@RequestMapping("signup")
	public String showSignUp()
	{
		return "SignUp";
	}
	
	@RequestMapping("aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
}
