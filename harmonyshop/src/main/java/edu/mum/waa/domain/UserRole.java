package edu.mum.waa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="UserRoles")
public class UserRole {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;	
	@NotEmpty
	String role;
	
	
	public UserRole(String role) {
		super();
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
	
}
