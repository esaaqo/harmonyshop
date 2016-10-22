package edu.mum.waa.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.waa.domain.Brand;
import edu.mum.waa.repositories.BrandRepository;
import edu.mum.waa.services.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
		
	BrandRepository brandRepository;
		
	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}	
	@Override
	public List<Brand> getAll(){
		return brandRepository.findAll();
	}		
	public Brand save(Brand newBrand){
		brandRepository.save(newBrand);
		return newBrand;
	}
}
