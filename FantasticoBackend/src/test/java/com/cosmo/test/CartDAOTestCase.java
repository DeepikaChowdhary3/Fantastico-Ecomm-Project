package com.cosmo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cosmo.dao.CartDAO;
import com.cosmo.model.Cart;
import com.cosmo.model.Category;


public class CartDAOTestCase {

	static CartDAO cartDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.cosmo");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void appendNewOrderTest()
	{
		Cart cart=new Cart();
		cart.setOrderId(9001);
		cart.setUserId("Deep_Chow");
		cart.setEmailId("chowxxx@gmail.com");
		cart.setMobileNo("+919986663331");
		cart.setProductId(1);
		cart.setProductName("Skinn by Titan - Celeste");
		cart.setQuantity(2);
		cart.setPrice(1000);
		cart.setOrderDate(new Date());
		cart.setPaymentMode("Cash on Delivery");
		cart.setShippingAddr("Chennai,TamilNadu");
		cart.setShippingStatus("Order Placed");
		assertTrue("Problem in placing an order",cartDAO.appendNewOrder(cart));
		
	}
	
	@Ignore
	@Test
	public void eraseOrderTest()
	{
		Cart cart=cartDAO.getOrderDetails(9001);
		assertTrue("Problem in deleting the order",cartDAO.eraseExistingOrder(cart));
	}
	
	@Ignore
	@Test
	public void listofOrdersTest()
	{
		List<Cart> listofOrders=cartDAO.listofOrders();
		assertTrue("Problem in Listing the Orders",listofOrders.size()>0);
		
		for(Cart cart:listofOrders)
		{
			System.out.println("Order ID:"+cart.getOrderId());
			System.out.println("User ID:"+cart.getUserId());
			System.out.println("User EmailId:"+cart.getEmailId());
			System.out.println("User MobileNo:"+cart.getMobileNo());
			System.out.println("Product Id:"+cart.getProductId());
			System.out.println("Product name:"+cart.getProductName());
			System.out.println("Quantity:"+cart.getQuantity());
			System.out.println("Price:"+cart.getPrice());
			System.out.println("Date of Order Placed:"+cart.getOrderDate());
			System.out.println("Payment mode:"+cart.getPaymentMode());
			System.out.println("Shipping Adrress:"+cart.getShippingAddr());
			System.out.println("Shippping Status:"+cart.getShippingStatus());
		}
	
	}
	

}
