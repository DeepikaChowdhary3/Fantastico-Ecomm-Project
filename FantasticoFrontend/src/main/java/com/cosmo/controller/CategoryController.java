package com.cosmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController{
	@RequestMapping("category")
	public String showCategory()
	{
		return "Category";
	}
}