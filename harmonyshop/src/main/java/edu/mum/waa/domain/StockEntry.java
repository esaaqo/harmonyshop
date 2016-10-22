package edu.mum.waa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import edu.mum.waa.domain.Stock;

@Entity
public class StockEntry{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @OneToOne @JoinColumn(name = "stockId")
	private Stock stock;	
	@NotNull @OneToOne @JoinColumn(name = "productId")
	private Product product;	
	@NotNull
	private Double quantity;
	public StockEntry(Stock stock, Product product, Double quantity) {
		super();
		this.stock = stock;
		this.product = product;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Stock getstock() {
		return stock;
	}
	public void setstock(Stock stock) {
		this.stock = stock;
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

