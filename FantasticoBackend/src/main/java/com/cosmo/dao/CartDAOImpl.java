package com.cosmo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cosmo.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean appendNewOrder(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean eraseExistingOrder(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Cart getOrderDetails(int orderId) {
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class, orderId);
		session.close();
		return cart;
	}

	@Override
	public List<Cart> listofOrders() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> listofOrders=query.list();
		session.close();
		return listofOrders;
	}

}
