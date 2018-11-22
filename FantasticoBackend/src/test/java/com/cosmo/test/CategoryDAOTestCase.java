package com.cosmo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cosmo.dao.CategoryDAO;
import com.cosmo.model.Category;

public class CategoryDAOTestCase 
{
	
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.cosmo");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void appendCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1005);
		category.setCategoryName("Hair-Care");
		category.setCategoryDesc("Get silky smooth and damage free hair");
		
		assertTrue("Probem in Adding the Category",categoryDAO.appendCategory(category));
	}
	
	@Ignore
	@Test
	public void eraseCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting the Category",categoryDAO.eraseCategory(category));
	}
	
	
	@Test
	public void reformCategoryTest()
	{	
		Category category=categoryDAO.getCategory(1003);
		category.setCategoryDesc("Look perfect with these awesome face care products");
		assertTrue("Problem in Updating the Category",categoryDAO.reformCategory(category));
	}

	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> Categorieslist=categoryDAO.Categorieslist();
		
		assertTrue("Problem in Listing the Categories",Categorieslist.size()>0);
		
		for(Category category:Categorieslist)
		{
			System.out.print("Category ID:"+category.getCategoryId());
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());
		}
	}
	
}







	
	






