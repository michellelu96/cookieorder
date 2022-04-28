package com.michelle.cookieorder.services;

import com.michelle.cookieorder.models.Cart;
import com.michelle.cookieorder.models.Product;

public interface CartService {

	public Cart addProductToCart(Cart cart,Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart,Product p,int quantity) ;
	public Cart viewAllProducts(Cart cart) ;
	public Cart removeAllProducts(Cart cart);
	public Cart getCartByCartId(Long  cartId);
}
