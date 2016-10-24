package edu.mum.waa.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class StockEntry{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@NotNull @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name = "productId")
	private Product product;	
	@NotNull
	private Double quantity;
	
	public StockEntry() {
		super();
	}
	public StockEntry(Product product, Double quantity) {
		super();;
		this.product = product;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}	
}

