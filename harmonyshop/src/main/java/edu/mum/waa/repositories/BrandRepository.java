package edu.mum.waa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.domain.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long>{
	List<Brand> findAll();
}
