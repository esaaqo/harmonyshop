package edu.mum.waa.services;

import java.util.List;

import edu.mum.waa.domain.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product findOne(Long id);
	public Product getProductByName(String productName);
	public Product save(Product newProduct);
	List<Product> search(String searchTerm);
}
