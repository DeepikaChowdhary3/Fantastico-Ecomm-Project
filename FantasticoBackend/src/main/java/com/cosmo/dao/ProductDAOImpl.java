package com.cosmo.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cosmo.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean appendProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean eraseProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean reformProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> Productslist() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> Productslist=query.list();
		session.close();
		return Productslist;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	}

}
