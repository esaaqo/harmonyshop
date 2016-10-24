package edu.mum.waa.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.StockEntry;

@Repository
public interface StockEntryRepository extends CrudRepository<StockEntry,Long>{	
	StockEntry save(StockEntry newStockEntry);	
}
