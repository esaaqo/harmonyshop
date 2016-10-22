package edu.mum.waa.services;

import java.util.List;

import edu.mum.waa.domain.Category;

public interface CategoryService {
	public List<Category> getAll();
	public Category save(Category newCategory);
}
