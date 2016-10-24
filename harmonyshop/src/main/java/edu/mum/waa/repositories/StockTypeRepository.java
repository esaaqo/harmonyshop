package edu.mum.waa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.StockEntry;
import edu.mum.waa.domain.StockType;

@Repository
public interface StockTypeRepository extends CrudRepository<StockType,Long>{
	public List<StockType> findAll();
}
