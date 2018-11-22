package com.cosmo.dao;

import java.util.List;

import com.cosmo.model.Cart;

public interface CartDAO {

	public boolean appendNewOrder(Cart cart);
	public boolean eraseExistingOrder(Cart cart);
	public Cart getOrderDetails(int orderId);
	public List<Cart> listofOrders();
	
}
