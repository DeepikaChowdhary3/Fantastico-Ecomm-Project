package com.cosmo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cosmo.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean appendnewUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateUserDetails(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<User> listofUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listofUsers=query.list();
		session.close();
		return listofUsers;
		
	}

	@Override
	public User getUser(String mobileNo) {
		Session session=sessionFactory.openSession();
		User user=session.get(User.class, mobileNo);
		session.close();
		return user;
	}

}
