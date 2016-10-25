package edu.mum.waa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();
	Product findProductByName(String productName);
	@Query("SELECT p FROM Product p where p.name like CONCAT('%',CONCAT(:searchTerm,'%')) or p.category like CONCAT('%',CONCAT(:searchTerm,'%')) or p.brand like CONCAT('%',CONCAT(:searchTerm,'%'))")
	List<Product> search(@Param("searchTerm")String searchTerm);
}
