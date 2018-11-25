package com.cosmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/signin")
	public String showSignIn()
	{
		return "SignIn";
	}
	
	@RequestMapping(value="/signup")
	public String showSignUp()
	{
		return "SignUp";
	}
	
	@RequestMapping(value="/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
}
