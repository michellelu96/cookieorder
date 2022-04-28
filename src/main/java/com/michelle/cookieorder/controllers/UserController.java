package com.michelle.cookieorder.controllers;




import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michelle.cookieorder.models.Cart;
import com.michelle.cookieorder.models.Product;
import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.services.CartService;
import com.michelle.cookieorder.services.ProductService;
import com.michelle.cookieorder.services.UserService;
import com.michelle.cookieorder.validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
    
    private UserValidator userValidator;
    
    // NEW
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
   //login page
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model,HttpSession session,HttpServletRequest request) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        if(session.getAttribute("userId") != null) {
        	return"redirect:/";
        }
        return "loginPage.jsp";
    }
    
    
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
        return "registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,HttpSession session) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        session.setAttribute("userId",user.getId());
        userService.saveWithUserRole(user);
        return "redirect:/";
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Model model, HttpSession session,HttpServletRequest request) {

    	if(session.getAttribute("userId") != null) {
    		model.addAttribute("user",userService.getUser((Long) session.getAttribute("userId")) );
    		model.addAttribute("products", productService.getThreeProducts());
    		return "home.jsp";
    	}
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();

        User u = userService.findByUsername(username);
        Long userId = u.getId();
        request.getSession().setAttribute("userId", u.getId());
        session.setAttribute("userId", userId);
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("products", productService.getThreeProducts());
        return "home.jsp";
    }
    /**  anythin with /admin is stuff only the admin can do!**/
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminPage.jsp";
    }

    
  	@GetMapping("/admin/cookie/addCookie")
  	public String newCookie(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model,HttpSession session){
  		return "addCookie.jsp";
  	}
  	
  	@PostMapping("/admin/cookie/addCookies")
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
  	
  	// show only product!
	@GetMapping("/oneCookie/{id}")
	public String getOne(@PathVariable("id") Long id, Model model){
		Product product = productService.getProductById(id);
		model.addAttribute("product",product);
		return "oneCookie.jsp";
	}
	
	//allCookies
	
	@GetMapping("/allCookies")
	public String getOne(Model model){
		model.addAttribute("products",productService.getAllProducts());
		return "allCookies.jsp";
	}
	
	@RequestMapping("/cart")
	public String getCartId(Model model){
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();

        User u = userService.findByUsername(username);
		model.addAttribute("cart", u.getCart());
		return "cart.jsp";
	}
	
	//add to cart?
	@PostMapping("/cart/add/{id}")
	public String addToCart(@PathVariable("id") Long id,HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("userId");
		if(userService.getUser(userId).getCart() != null) {
			cartService.addProductToCart(userService.getUser(userId).getCart(), productService.getProductById(id), 1);
		}
		Cart newCart = new Cart();
		userService.getUser(userId).setCart(cartService.addProductToCart(newCart,productService.getProductById(id),1));
		return"redirect:/cart";
	}
    
}
