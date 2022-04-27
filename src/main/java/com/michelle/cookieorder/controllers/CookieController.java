package com.michelle.cookieorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.michelle.cookieorder.services.ProductService;

@Controller
public class CookieController {
	@Autowired
	private ProductService productService;

	

}
