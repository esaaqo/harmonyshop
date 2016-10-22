package edu.mum.waa.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Product;
import edu.mum.waa.domain.User;
import edu.mum.waa.repositories.ProductRepository;
import edu.mum.waa.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
		
	ProductRepository productRepository;
		
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	@Override
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	@Override
	public Product getProductByName(String productName){
		return productRepository.findProductByName(productName);
	}
	@Override
	public Product save(Product newProduct){
		return productRepository.save(newProduct);
	}
}
