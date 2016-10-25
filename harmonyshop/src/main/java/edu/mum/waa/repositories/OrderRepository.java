package edu.mum.waa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long>{
	Order findOne(Long id);
	Order save(Order order);
	@Query("SELECT o from Orders o JOIN o.employee client JOIN o.orderType orderType WHERE client.userName = :userName and orderType.id = 1")
	Order getOrderByUserName(@Param("userName") String userName);
}
