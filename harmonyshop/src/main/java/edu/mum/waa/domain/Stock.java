package edu.mum.waa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Stock {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull @OneToOne @JoinColumn(name="clientId")
	private User user;
	@NotNull @Temporal(TemporalType.DATE)
	private Date date;
	@NotNull 
	@OneToOne @JoinColumn(name="typeId")
	private StockType stockType;
	@NotEmpty 
	@Valid
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name = "stockId")
	private List<StockEntry> stockEntries=new ArrayList<StockEntry>();
	private String Description;	
	
	public Stock() {
		super();
	}
	public Stock(User user, Date date, StockType stockType, String description) {
		super();
		this.user = user;
		this.date = date;
		this.stockType = stockType;
		Description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public StockType getStockType() {
		return stockType;
	}
	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<StockEntry> getStockEntries() {
		return stockEntries;
	}
	public void setStockEntries(List<StockEntry> stockEntries) {
		this.stockEntries = stockEntries;
	}
		
}
