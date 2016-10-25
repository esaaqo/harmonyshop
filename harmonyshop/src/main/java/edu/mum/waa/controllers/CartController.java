package edu.mum.waa.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.waa.domain.Brand;
import edu.mum.waa.domain.Order;
import edu.mum.waa.domain.OrderLine;
import edu.mum.waa.domain.Product;
import edu.mum.waa.domain.User;
import edu.mum.waa.services.BrandService;
import edu.mum.waa.services.OrderService;
import edu.mum.waa.services.OrderTypeService;
import edu.mum.waa.services.ProductService;
import edu.mum.waa.services.UserService;


@Controller
@RequestMapping(value="/cart")
public class CartController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;	
	@Autowired
	OrderTypeService orderTypeService;
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	

	@RequestMapping(value="/add/{productId}", method = RequestMethod.GET)
	public String add(@PathVariable("productId") Long productId,Principal principal,HttpServletRequest request){
		HttpSession session = request.getSession(true);
		Order order = (Order)session.getAttribute("cart");
		if(order == null){	
			
			User client = userService.searchByUserName(principal.getName());
			order = orderService.getOrderByUserName(client.getUserName());
			if(order==null){
				order = new Order();
				order.setClient(client);
				order.setDate(new Date());
				order.setOrderType(orderTypeService.findOne(1L));//for cart
				orderService.save(order);
				session.setAttribute("cart", order);
			}
			Product addProdcuct =  productService.findOne(productId);
			OrderLine orderLine = new OrderLine(addProdcuct,1D);
			//orderLine.set;
			order.getOrderLines().add(orderLine);
			System.out.println("cart items: " + order.getOrderLines());
			orderService.save(order);
			//order.getOrderLines().add(e)
		}
		return "cart";
	}
	@RequestMapping(value="/remove/{productId}", method = RequestMethod.GET)
	public String remove(@PathVariable("productId") Long productId,Principal principal,HttpServletRequest request){
		HttpSession session = request.getSession(true);
		Order order = (Order)session.getAttribute("cart");
		if(order == null){	
			
			User client = userService.searchByUserName(principal.getName());
			order = orderService.getOrderByUserName(client.getUserName());
			if(order==null){
				order = new Order();
				order.setClient(client);
				order.setDate(new Date());
				order.setOrderType(orderTypeService.findOne(1L));//for cart
				orderService.save(order);
				session.setAttribute("cart", order);
			}
			Product addProdcuct =  productService.findOne(productId);
			OrderLine orderLine = new OrderLine(addProdcuct,1D);
			//orderLine.set;
			//for()
			System.out.println("cart items: " + order.getOrderLines().size());
			orderService.save(order);
			//order.getOrderLines().add(e)
		}
		return "cart";
	}	
/*	@RequestMapping(value="/save", method = RequestMethod.POST)
	public @ResponseBody Brand save(@Valid @RequestBody Brand newBrand) {
		brandService.save(newBrand);
		return newBrand;
	}*/
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}*/
}
