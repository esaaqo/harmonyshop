package edu.mum.waa.services;

import edu.mum.waa.domain.Order;

public interface OrderService {
	Order findOne(Long id);
	Order save(Order order);
	Order getOrderByUserName(String userName);
}
