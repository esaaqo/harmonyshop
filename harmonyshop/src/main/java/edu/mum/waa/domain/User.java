package edu.mum.waa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.waa.validators.UserEmail;
import edu.mum.waa.validators.UserUserName;

@Entity
@Table(name="Users")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;	
	@Size(min = 3,message="{users.userName.error.minlength}")
	@UserUserName @NotNull(message="{users.userName.error.null}")
	@Column(unique=true)
	String userName;
	@NotEmpty(message="{users.firstName.error.empty}")
	String firstName;
	@NotEmpty(message="{users.lastName.error.empty}")
	String lastName;	
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="{users.email.error.pattern}")
	@UserEmail @NotEmpty(message="{users.email.error.empty}")
	String email;
	@Size(min=4,max=20,message="{users.password.error}")
	String password;
	@NotNull @OneToMany(cascade=CascadeType.PERSIST) @JoinColumn(name="userId")
	List<UserRole> userRoles = new ArrayList<UserRole>();
	@Valid @OneToOne @JoinColumn(name = "addressId")
	Address address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void addUserRole(UserRole userRole) {		
		this.userRoles.add(userRole);
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
