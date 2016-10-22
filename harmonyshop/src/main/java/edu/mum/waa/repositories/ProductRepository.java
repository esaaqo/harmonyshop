package edu.mum.waa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();
	Product findProductByName(String productName);
}
