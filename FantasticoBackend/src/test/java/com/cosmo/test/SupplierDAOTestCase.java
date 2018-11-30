package com.cosmo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cosmo.dao.SupplierDAO;
import com.cosmo.model.Supplier;

public class SupplierDAOTestCase 
{
	
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.cosmo");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(2003);
		supplier.setSupplierName("Quick exports");
		supplier.setSupplierAddr("Hyderabad,AndraPradesh.");
		
		assertTrue("Probem in Adding the Supplier",supplierDAO.appendSupplier(supplier));
	}

	@Test
	public void updateSupplierTest()
	{	
		Supplier supplier=supplierDAO.getSupplier(2001);
		supplier.setSupplierAddr("Chennai,TamilNadu");	
		assertTrue("Problem in Updating the Supplier",supplierDAO.reformSupplier(supplier));
	}
	
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2001);
		assertTrue("Problem in deleting the Supplier",supplierDAO.eraseSupplier(supplier));
	}
	
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> Supplierslist=supplierDAO.Supplierslist();
		
		assertTrue("Problem in Listing the Suppliers",Supplierslist.size()>0);
		
		for(Supplier supplier:Supplierslist)
		{
			System.out.print("Supplier ID:"+supplier.getSupplierId());
			System.out.print("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Desc:"+supplier.getSupplierAddr());
		}
	}
	
}







	
	






