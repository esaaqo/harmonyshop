package edu.mum.waa.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.waa.domain.Product;
import edu.mum.waa.services.BrandService;
import edu.mum.waa.services.CategoryService;
import edu.mum.waa.services.ProductService;

@Controller
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ServletContext servletContext;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> list() {
		return productService.getAll();
	}
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveForm(Model model,@ModelAttribute("newProduct") Product newProduct) {
		model.addAttribute("categories",categoryService.getAll());
		model.addAttribute("brands",brandService.getAll());
		return "products/productForm";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) 	
			return "products/productForm";
		 String[] suppressedFields = bindingResult.getSuppressedFields();
		 
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		MultipartFile image = newProduct.getImageFile(); 		
		String rootDirectory = servletContext.getRealPath("/");
 		String imageName = newProduct.getName() + "." + image.getOriginalFilename().split("\\.")[1];	
		if (image!=null && !image.isEmpty()) {
	       try {
	    	   image.transferTo(new File(rootDirectory+"\\resources\\images\\products\\"+imageName));
	       } catch (Exception e) {
	    	System.out.println(e.getMessage());
			throw new RuntimeException("Image saving failed", e);
	    }
		}		
		newProduct.setImageName(imageName);
		productService.save(newProduct);
		
		redirectAttributes.addAttribute("productId",newProduct.getId());
		return "redirect:show";
	}	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public String saveForm(@RequestParam Long productId,Model model){
		model.addAttribute("newProduct",productService.findOne(productId));
		return "products/productShow";
	}
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(@RequestParam("searchTerm") String searchTerm,Model model){
		model.addAttribute("products",productService.search(searchTerm));
		return "products/products";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
