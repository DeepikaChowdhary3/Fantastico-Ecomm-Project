package com.cosmo.dao;

import java.util.List;

import com.cosmo.model.Product;

public interface ProductDAO {

	public boolean appendProduct(Product product);
	public boolean eraseProduct(Product product);
	public boolean reformProduct(Product product);
	public List<Product> Productslist();
	public Product getProduct(int productId);
	
}
