package edu.mum.waa.domain;

import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String model;
	@NotNull
	private String specification;	
	@NotNull
	private Float price;	
	@NotNull @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "brandId")
	private Brand brand;
	@NotNull @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "categoryId")
	private Category category;
	private String imageName;
	@JsonIgnore
	@Transient
	private MultipartFile imageFile; 
	public Product() {
		super();
	}
	public Product(String name, String model, String specification, Float price, Brand brand, Category category) {
		super();
		this.name = name;
		this.model = model;
		this.specification = specification;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}
	public Product(String name, String model, String specification, Float price) {
		super();
		this.name = name;
		this.model = model;
		this.specification = specification;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	
}
