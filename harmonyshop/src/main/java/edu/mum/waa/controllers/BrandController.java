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

import edu.mum.waa.domain.Brand;
import edu.mum.waa.services.BrandService;


@Controller
@RequestMapping(value="/brands")
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
	

	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<Brand> list() {
		return brandService.getAll();
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public @ResponseBody Brand save(@Valid @RequestBody Brand newBrand) {
		brandService.save(newBrand);
		return newBrand;
	}
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}*/
}
