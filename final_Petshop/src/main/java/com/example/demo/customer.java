package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class customer {
	@Id
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="name")
	private String name;
	
	private String telephone;
	private String email;
	
	@JsonIgnore
	@ManyToOne(optional=false)
	@JoinColumn(name="id_address")
	private address address;
	public address getaddress() {
		return address;
	}
	public address getAddress() {
		return address;
	}
	public void setAddress(address address) {
		this.address = address;
	}
	public void setaddress(address c) {
		this.address=c;
	}
	

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public customer(int id_user, String name, String telephone, String email) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		
	}
	public customer(com.example.demo.address address) {
		super();
		this.address = address;
	}
	public customer() {
		super();
	}

	@Override
	public String toString() {
		return "customer [id=" + id_user + ", name=" + name + ", telephone=" + telephone + ", email=" + email + ", address="
				+ address + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
