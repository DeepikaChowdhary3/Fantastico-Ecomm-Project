package com.cosmo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cosmo.dao.UserDAO;
import com.cosmo.model.User;

public class UserDAOTestCase {

	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.cosmo");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	
	@Test
	public void registerUserTest() {
		User user=new User();
		user.setUserId("Deep_Chow");
		user.setPassword("typewr6");
		user.setEnabled(true);
		user.setRole("Supreme_User");
		user.setCustomerName("Chowdhary");
		user.setMobileNo("9996663330");
		user.setEmailId("Chowxxx@gmail.com");
		user.setAddress("Coimbatore,TamilNadu");
		assertTrue("Problem in registering the new user",userDAO.appendnewUser(user));
		
	}
	

	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser("Deep_Chow");
		user.setMobileNo("+919986663331");
		assertTrue("Problem in udate the user details",userDAO.updateUserDetails(user));
	}


	@Test
	public void ListOfUsersTest()
	{
		List<User> listofUsers=userDAO.listofUsers();
		assertTrue("Problem in listing the users",listofUsers.size()>0);
		
		for(User user:listofUsers)
		{
			System.out.println("Custeomer name: "+user.getCustomerName());
			System.out.println("User Name: "+user.getUserId());
			System.out.println("Password: "+user.getPassword());
			System.out.println("User Status: "+user.isEnabled());
			System.out.println("Mobile Number: "+user.getMobileNo());
			System.out.println("Email: "+user.getEmailId());
			System.out.println("Address: "+user.getAddress());
			System.out.println("Role of the user: "+user.getRole());
		}
		
	}
}
