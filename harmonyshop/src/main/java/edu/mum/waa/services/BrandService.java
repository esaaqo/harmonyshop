package edu.mum.waa.services;

import java.util.List;

import edu.mum.waa.domain.Brand;

public interface BrandService {
	public List<Brand> getAll();
	public Brand save(Brand newBrand);
}
