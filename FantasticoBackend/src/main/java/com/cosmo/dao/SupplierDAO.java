package com.cosmo.dao;

import java.util.List;

import com.cosmo.model.Supplier;

public interface SupplierDAO {

	public boolean appendSupplier(Supplier supplier);
	public boolean eraseSupplier(Supplier supplier);
	public boolean reformSupplier(Supplier supplier);
	public List<Supplier> Supplierslist();
	public Supplier getSupplier(int supplierId);
}
