package com.cosmo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cosmo.dao.ProductDAO;
import com.cosmo.model.Product;

public class ProductDAOTestCase {

	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.cosmo");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void appendProductTest() {
		Product product=new Product();
		
		product.setProductName("Lakme Matte");
		product.setProductDesc("Go awesome with maroon mix of matte lips");
		product.setSupplierId(2001);
		product.setCategoryId(1002);
		product.setPrice(400);
		product.setStock(15);
		assertTrue("Probem in Adding the Product",productDAO.appendProduct(product));
	}
	@Ignore
	@Test
	public void eraseProductTest() {
		Product product=productDAO.getProduct(1);
		assertTrue("Problem in deleting the product",productDAO.eraseProduct(product));
	}
	@Ignore
	@Test
	public void reformProductTest() {
		Product product=productDAO.getProduct(1);
		product.setProductDesc("Celeste from skinn Titan has a musk and a fruity scent");
		assertTrue("Problem in updating the product",productDAO.reformProduct(product));
	}
	
	@Ignore
	@Test
	public void ProductsList() {
		List<Product> Productslist=productDAO.Productslist();
		assertTrue("Problem in listing the products",Productslist.size()>0);
		for(Product product:Productslist)
		{
			System.out.println("Product ID: "+product.getProductId());
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Product Description: "+product.getProductDesc());
			System.out.println("Product Price: "+product.getPrice());
			System.out.println("Product Stock availability: "+product.getStock());
			System.out.println("Product Supplier Id: "+product.getSupplierId());
			System.out.println("Product Category Id:"+product.getCategoryId());
			System.out.println();
		}
	}

}
