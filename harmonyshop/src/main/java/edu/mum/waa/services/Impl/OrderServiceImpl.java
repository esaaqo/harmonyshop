package edu.mum.waa.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Order;
import edu.mum.waa.repositories.OrderRepository;
import edu.mum.waa.services.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
		
	OrderRepository orderRepository;
		
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}	
	@Override
	public Order findOne(Long id){
		return orderRepository.findOne(id);
	}
	@Override
	public Order save(Order order){
		return orderRepository.save(order);
	}
	@Override
	public Order getOrderByUserName(String userName){
		return orderRepository.getOrderByUserName(userName);
	}
}
