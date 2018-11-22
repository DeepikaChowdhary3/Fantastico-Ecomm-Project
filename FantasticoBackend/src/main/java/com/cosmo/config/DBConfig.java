package com.cosmo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cosmo.dao.CartDAO;
import com.cosmo.dao.CartDAOImpl;
import com.cosmo.dao.CategoryDAO;
import com.cosmo.dao.CategoryDAOImpl;
import com.cosmo.dao.ProductDAO;
import com.cosmo.dao.ProductDAOImpl;
import com.cosmo.dao.SupplierDAO;
import com.cosmo.dao.SupplierDAOImpl;
import com.cosmo.dao.UserDAO;
import com.cosmo.dao.UserDAOImpl;
import com.cosmo.model.Cart;
import com.cosmo.model.Category;
import com.cosmo.model.Product;
import com.cosmo.model.Supplier;
import com.cosmo.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.cosmo")

public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(" jdbc:h2:tcp://localhost/~/EcommProject");
		dataSource.setUsername("h2");
		dataSource.setPassword("h2");
		System.out.println("Data Source object is created");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProp);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(User.class);
		factory.addAnnotatedClass(Cart.class);
		System.out.println("Session Factory object is created");
		return factory.buildSessionFactory();		
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("Category Bean has been Created");
		return new CategoryDAOImpl();
	} 
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("Product Bean has been Created");
		return new ProductDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("Supplier Bean has been Created");
		return new SupplierDAOImpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("User Bean has been Created");
		return new UserDAOImpl();
	}
	
	@Bean(name="cartDAO")
	public CartDAO getCartDAO()
	{
		System.out.println("Cart Bean has been Created");
		return new CartDAOImpl();
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction manager object is created");
		return new HibernateTransactionManager(sessionFactory);
	}
}
