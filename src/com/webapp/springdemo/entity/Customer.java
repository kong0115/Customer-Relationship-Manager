package com.webapp.springdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="Required")
	@Size(min=1, message="Required")
	@Pattern(regexp="^([a-zA-Z\\.\\,\\-]+ )*([a-zA-Z\\\\.\\\\,\\\\-]+)$", message="Invalid First Name")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="Required")
	@Size(min=1, message="Required")
	@Pattern(regexp="^([a-zA-Z\\.\\,\\-]+ )*([a-zA-Z\\\\.\\\\,\\\\-]+)$", message="Invalid Last Name")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message="Required")
	@Size(min=1, message="Required")
	@Pattern(regexp="^(([^<>()\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message="Invalid Email")
	private String email;
	
	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
