package edu.mum.waa.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.domain.Product;
import edu.mum.waa.domain.Stock;
import edu.mum.waa.domain.StockType;
import edu.mum.waa.domain.User;
import edu.mum.waa.services.ProductService;
import edu.mum.waa.services.StockService;
import edu.mum.waa.services.StockTypeService;
import edu.mum.waa.services.UserService;


@Controller
@RequestMapping(value="/stock")
public class StockController {
	
	@Autowired
	StockService stockService;
	@Autowired
	ProductService productService;	
	@Autowired
	StockTypeService stockTypeService;
	@Autowired
	UserService userService;
	
	@ModelAttribute("stockTypes")
	public List<StockType>stockTypes(){
		return stockTypeService.getAll();
	}
	@ModelAttribute("products")
	public List<Product> products(){
		return productService.getAll();
	}
	private static final Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveForm(@ModelAttribute("newStock") Stock newStock,Model model) 	{
		return "stock/stockForm";
	}	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("newStock") Stock newStock, BindingResult bindingResult,Model model,Principal principal,RedirectAttributes redirectAttributes  ) {
		if(bindingResult.hasErrors())
			return "stock/stockForm";

		String[] suppressedFields = bindingResult.getSuppressedFields();
		
		if (suppressedFields.length > 0){
			System.out.println("error in code");
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
		User user = userService.searchByUserName(principal.getName());
		newStock.setUser(user);
		stockService.save(newStock);
		redirectAttributes.addFlashAttribute("newStock",stockService.getOne(newStock.getId()));
		return "redirect:show";
	}
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public String saveForm(){
		return "stock/stockShow";
	}
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}*/
}
