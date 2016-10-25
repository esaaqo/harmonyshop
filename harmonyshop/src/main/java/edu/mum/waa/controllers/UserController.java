package edu.mum.waa.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

import edu.mum.waa.domain.User;
import edu.mum.waa.domain.UserRole;
import edu.mum.waa.services.ProductService;
import edu.mum.waa.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = { "/","/welcome" }, method = RequestMethod.GET)
	public String account(Model model,Principal principal) {	
		model.addAttribute("products",productService.getAll());
		return "welcome";
		//return "users/account";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "users/login";
	}
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "users/login";
	}
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signupDisplay(@ModelAttribute("newUser") User user,Model model) {
		return "users/signup";
	}
	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public String signupSave(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult , Model model) {

		if(bindingResult.hasErrors()) {
			if(bindingResult.getErrorCount()==1 && ((FieldError)bindingResult.getAllErrors().get(0)).getField().equals("userRoles"));
			else
				return "users/signup";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		UserRole ROLE_USER = new UserRole("ROLE_USER");
		user.addUserRole(ROLE_USER);
		userService.save(user);
		return "users/login";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	@RequestMapping(value = { "/tile" }, method = RequestMethod.GET)
	public String tile(Model model) {
		System.out.println("tile");
		return "welcome";
	}	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	    binder.setDisallowedFields("userRoles");
	}
}
