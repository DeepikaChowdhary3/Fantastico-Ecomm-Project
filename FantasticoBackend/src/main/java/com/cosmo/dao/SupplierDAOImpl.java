package com.cosmo.dao;

import java.util.List;



import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cosmo.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean appendSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean eraseSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean reformSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public List<Supplier> Supplierslist() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> Supplierslist=query.list();
		session.close();
		return Supplierslist;
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}
}
				