package edu.mum.waa.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Category;
import edu.mum.waa.repositories.CategoryRepository;
import edu.mum.waa.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
		
	CategoryRepository categoryRepository;
		
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	@Override
	public Category save(Category category){
		categoryRepository.save(category);
		return category;
	}
	@Override
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
}
