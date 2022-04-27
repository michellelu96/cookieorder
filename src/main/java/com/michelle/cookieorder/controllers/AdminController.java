package com.michelle.cookieorder.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michelle.cookieorder.models.Product;
import com.michelle.cookieorder.services.ProductService;
import com.michelle.cookieorder.services.UserService;

/// things that only admins can do

public class AdminController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminPage.jsp";
    }

    //only admins can add the cookie!!!!!!!!
	@GetMapping("/admin/cookie/addCookie")
	public String newCookie(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model,HttpSession session){
		return "addCookie.jsp";
	}
	
	@PostMapping("/admin/cookie/addCookie")
	public String makeNewCookie(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model){
		if(result.hasErrors()) return "addCookie.jsp";
		else {
			productService.createProduct(product);
			return "redirect:/admin";
		}
	}
	
	@GetMapping("/admin/cookie/edit/{id}")
	public String editCookie(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product",product);
		return "editCookie.jsp";
	}
	
	@PutMapping("/admin/cookie/edit/{id}")
	public String updateCookie(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model,@PathVariable("id") Long id) {
		if(result.hasErrors()) return "editCookie.jsp";
		else {
			productService.updateProduct(product);
			return "redirect:/admin";
		}
	}
	
	@DeleteMapping("/admin/cookie/delete/{id}")
	public String deleteCookie(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/admin";
	}
}
