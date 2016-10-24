package edu.mum.waa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OrderLine{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @OneToOne @JoinColumn(name = "orderId")
	private Order order;	
	@NotNull @OneToOne @JoinColumn(name = "productId")
	private Product product;	
	@NotNull
	private Double quantity;
	
	public OrderLine() {
		super();
	}	
	public OrderLine(Order order, Product product, Double quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
