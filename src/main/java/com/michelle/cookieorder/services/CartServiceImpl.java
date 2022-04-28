package com.michelle.cookieorder.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.michelle.cookieorder.models.Cart;
import com.michelle.cookieorder.models.Product;
import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.repositories.CartRepository;
import com.michelle.cookieorder.repositories.ProductRepository;
import com.michelle.cookieorder.repositories.UserRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private ProductRepository proRepo;
    
    @Autowired
    private UserRepository userRepo;
    
	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity){
		p.setCookieQuantity(quantity);
		
		proRepo.save(p);
		cartRepo.save(cart);	
		List<Product> list=new ArrayList<>();
		list.add(p);
		cart.setProducts(list);			
		     	return cart;
	}
	
	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		p.setCookieQuantity(quantity);
		cartRepo.save(cart);
		proRepo.save(p);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Product> list=new ArrayList();
		list.add(p);
		cart.setProducts(list);
		return cart;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Cart viewAllProducts(Cart cart) {
		
		Optional<Product> product=proRepo.findById(cart.getId());
		Product products = null;
		if(product.isPresent()) products = product.get();
		Optional<User> user=userRepo.findById(cart.getId());
		User users = null;
		if(user.isPresent()) users = user.get();
		@SuppressWarnings("unchecked")
		List<Product> list=new ArrayList();
		list.add(products);
		cart.setProducts(list);
		cart.setUser(users);
		return cart;	
	}
	
	@Override
	public Cart removeAllProducts(Cart cart) {
		Optional<Cart> cart1 = cartRepo.findById(cart.getId());
		Cart cart2 = null;
		if(cart1.isPresent()) cart2 = cart1.get();
		proRepo.deleteAll(cart2.getProducts());
		List<Product> products = cart2.getProducts();
		products.clear();
		cartRepo.save(cart2);
		return cart2;		
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		Optional<Cart> cart1 = cartRepo.findById(cart.getId());
		Cart cart2 = null;
		if(cart1.isPresent()) cart2 = cart1.get();
		List<Product> list = cart2.getProducts();
		for (Product product : list) {
			if(product.getId().equals(p.getId())) {
				proRepo.delete(p);
				list.remove(p);
				break;
			}
		}
		cartRepo.save(cart2);
		return cart2;
		
	}
}
