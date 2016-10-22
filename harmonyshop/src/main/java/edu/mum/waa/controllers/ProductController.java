package edu.mum.waa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Product;
import edu.mum.waa.services.BrandService;
import edu.mum.waa.services.CategoryService;
import edu.mum.waa.services.ProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> list() {
		return productService.getAll();
	}
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveFrom(Model model,@Valid @ModelAttribute("newProduct") Product newProduct) {
		model.addAttribute("categories",categoryService.getAll());
		model.addAttribute("brands",brandService.getAll());
		return "product";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("newProduct") Product newProduct) {
		productService.save(newProduct);
		return "product";
	}	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
