package com.cosmo.dao;

import java.util.List;

import com.cosmo.model.Category;

public interface CategoryDAO {

	public boolean appendCategory(Category category);
	public boolean eraseCategory(Category category);
	public boolean reformCategory(Category category);
	public List<Category> Categorieslist();
	public Category getCategory(int categoryId);
	
}
