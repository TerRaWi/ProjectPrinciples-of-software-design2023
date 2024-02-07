package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CustomerRepository customRepo;
	@Autowired
	public InventoryService() {}
	//@Autowired //Constructor dependency injection
	public InventoryService(CategoryRepository catRepo, ProductRepository productRepo, CustomerRepository customRepo) {
		this.catRepo = catRepo;
		this.productRepo = productRepo;
		this.customRepo  = customRepo;
	}
	
	public List<Category> getAllCategory(){
		List<Category> cats = (List<Category>) this.catRepo.findAll();
		return cats;
	}
	public List<Product> getAllProduct(){
		List<Product> Product = (List<Product>) this.productRepo.findAll();
		return Product;
	}
	public List<customer> getAllCustomer(){
		List<customer> customer = (List<customer>) this.customRepo.findAll();
		return customer;
	}
}
