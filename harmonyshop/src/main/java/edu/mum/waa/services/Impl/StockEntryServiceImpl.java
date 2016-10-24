package edu.mum.waa.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.StockEntry;
import edu.mum.waa.repositories.StockEntryRepository;

import edu.mum.waa.services.StockEntryService;


@Service
public class StockEntryServiceImpl implements StockEntryService {
		
	StockEntryRepository stockEntryRepository;
		
	@Autowired
	public StockEntryServiceImpl(StockEntryRepository stockEntryRepository) {
		super();
		this.stockEntryRepository = stockEntryRepository;
	}	
	
	public StockEntry save(StockEntry newStockEntry){
		stockEntryRepository.save(newStockEntry);
		return newStockEntry;
	}
}
