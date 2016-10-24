package edu.mum.waa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Category;
import edu.mum.waa.services.CategoryService;

@Controller
@RequestMapping(value="/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<Category> list() {
		return categoryService.getAll();
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public @ResponseBody Category save(@Valid @RequestBody Category newCategory) {
		categoryService.save(newCategory);
		return newCategory;
	}
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}*/
}
