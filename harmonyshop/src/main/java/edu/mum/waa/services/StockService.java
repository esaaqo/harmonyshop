package edu.mum.waa.services;

import edu.mum.waa.domain.Stock;

public interface StockService {
	public Stock save(Stock newStock);
	public Stock getOne(Long id);
}
