package edu.mum.waa.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Stock;
import edu.mum.waa.repositories.StockRepository;
import edu.mum.waa.services.StockService;


@Service
public class StockServiceImpl implements StockService {
		
	StockRepository stockRepository;
		
	@Autowired
	public StockServiceImpl(StockRepository stockRepository) {
		super();
		this.stockRepository = stockRepository;
	}	
	
	@Override
	public Stock save(Stock newStock){
		stockRepository.save(newStock);
		return newStock;
	}
	@Override
	public Stock getOne(Long id){
		return stockRepository.findOne(id);
	}
}
