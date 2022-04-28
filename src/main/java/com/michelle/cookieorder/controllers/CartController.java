package com.michelle.cookieorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.michelle.cookieorder.models.Cart;
import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.services.CartService;
import com.michelle.cookieorder.services.UserService;


@Controller
public class CartController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;


	
	@RequestMapping("cart/getCartById")
	public String getCartId(Model model){
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();

        User u = userService.findByUsername(username);
		model.addAttribute("cart", u.getCart().getId());
		return "cart.jsp";
	}
	
	@RequestMapping("/cart/getCart/{id}")
	public @ResponseBody Cart getCartItems(@PathVariable(value="id")Long id){
		return cartService.getCartByCartId(id);
	}
	
}
