package edu.mum.waa.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.OrderType;
import edu.mum.waa.repositories.OrderTypeRepository;
import edu.mum.waa.services.OrderTypeService;


@Service
public class OrderTypeServiceImpl implements OrderTypeService {
		
	OrderTypeRepository orderTypeRepository;
		
	@Autowired
	public OrderTypeServiceImpl(OrderTypeRepository orderTypeRepository) {
		super();
		this.orderTypeRepository = orderTypeRepository;
	}	
	@Override
	public OrderType findOne(Long id){
		return orderTypeRepository.findOne(id);
	}
}
