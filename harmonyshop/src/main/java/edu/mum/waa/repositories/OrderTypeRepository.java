package edu.mum.waa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Order;
import edu.mum.waa.domain.OrderType;

@Repository
public interface OrderTypeRepository extends CrudRepository<OrderType,Long>{
	OrderType findOne(Long id);
}
