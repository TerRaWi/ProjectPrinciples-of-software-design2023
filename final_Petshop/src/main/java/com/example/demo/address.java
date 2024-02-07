package com.example.demo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="id_address")
	private int id_address;
	private String address_line1;
	private String address_line2;
	private String zipecode;
	private String zipcode;
	
	
	
	
	public int getId_address() {
		return id_address;
	}
	public void setId_address(int id_address) {
		this.id_address = id_address;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getZipecode() {
		return zipecode;
	}
	public void setZipecode(String zipecode) {
		this.zipecode = zipecode;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@OneToMany(targetEntity=customer.class,mappedBy="address", 
			cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<customer> customers;
	public List<customer> getcustomers() {
		return customers;
	}
	public void setcustomers(List<customer> customers) {
		this.customers = customers;
	}
	public address() {
		super();
	}
	
	

}
