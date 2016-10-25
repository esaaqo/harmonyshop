package edu.mum.waa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,Long>{
	//@Query("SELECT p FROM Product p ")
}
