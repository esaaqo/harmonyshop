package edu.mum.waa.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity(name="Orders")
public class Order{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @Valid @OneToOne @JoinColumn(name="employeeId")
	private User employee;
	@NotNull @Temporal(TemporalType.DATE)
	private Date date;
	@NotNull @OneToOne @JoinColumn(name="typeId")
	private OrderType orderType;
	@NotNull @OneToOne @JoinColumn(name="shippingAddressId")
	private Address shippingAddress;
	@NotNull @OneToOne @JoinColumn(name="billingAddressId")
	private Address billingAddress;	
	public Order(User client, Date date, OrderType orderType) {
		super();
		this.employee = client;
		this.date = date;
		this.orderType = orderType;
	}
	
	public Order() {
		super();
	}

	public Order(User employee, Date date, OrderType orderType, Address shippingAddress, Address billingAddress) {
		super();
		this.employee = employee;
		this.date = date;
		this.orderType = orderType;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getClient() {
		return employee;
	}
	public void setClient(User employee) {
		this.employee = employee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
		
}
