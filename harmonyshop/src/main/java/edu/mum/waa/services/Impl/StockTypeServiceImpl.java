package edu.mum.waa.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.StockType;
import edu.mum.waa.repositories.StockTypeRepository;
import edu.mum.waa.services.StockTypeService;


@Service
public class StockTypeServiceImpl implements StockTypeService {
		
	StockTypeRepository stockTypeRepository;
		
	@Autowired
	public StockTypeServiceImpl(StockTypeRepository stockTypeRepository) {
		super();
		this.stockTypeRepository = stockTypeRepository;
	}	
	

	@Override
	public List<StockType> getAll(){
		return stockTypeRepository.findAll();
	}
}
