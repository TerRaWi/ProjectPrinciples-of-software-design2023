package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OneToManyController {
	private InventoryService invSer;
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private CustomerRepository CustomerRepository;
	//@Autowired
	public InventoryService getInvSer() {
		return invSer;
	}
	
//	@Autowired//setter dependency injection
//	public void setInvSer(InventoryService invSer) {
//		this.invSer = invSer;
//	}
	
	
	//@Autowired
	public OneToManyController(InventoryService invSer) {
		this.invSer = invSer;
	}
	
	 @GetMapping("/admin")
		public String admin() {
		
			return "admin";
		}

	 @GetMapping("/categoryList")
		public String getListOfCateryList (Model model) {
		List<Category> categorys= invSer.getAllCategory();
		model.addAttribute("categorys",categorys);
			return "categoryList";
		}
	 
	 
	 @GetMapping("/list_product")
		public String  getproduct(Model model) {
		 List<Product> Product = invSer.getAllProduct();
		 model.addAttribute("products",Product);
			return "productList";
		}
	
	 
	 @GetMapping("/customer")
		public String getcustomer(Model model) {
		List<customer> customer= invSer.getAllCustomer();
		model.addAttribute("customer",customer);
			return "customerList";
		}
	 @GetMapping("/new_category")
		public String showForm(Model model) {
			Category category = new Category();
			 model.addAttribute("category", category);
		 return "new_category";
		}
	 

	 
	 
	 
	 @PostMapping("/new_category")
		public String submitcategory(@ModelAttribute("category") Category Category) {
		 System.out.println(Category.getId());
		 System.out.println(Category.getName());
		 CategoryRepository.save(Category);
		 return "new_category";
		}
	 
	 @GetMapping("/new_product")
		public String showFormProduct(Model model) {
		 Product Product = new Product();
			 model.addAttribute("product", Product);
		 return "new_product";
		}
	 
	 @PostMapping("/new_product")
		public String submitProduct(@ModelAttribute("product") Product Product) {
		 System.out.println(Product.getProductId());
		 System.out.println(Product.getName());
		 ProductRepository.save(Product);
		 return "new_product";
		}
	 
	 
	 
	 
	 
	 
	 ////////edit///

	 
	 @GetMapping("/update_category/{id}")
		public String update (@PathVariable("id") int id , Model model) {
		 Category category = CategoryRepository.findById(id)
					.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
			model.addAttribute("category",category);
					return "update_category";
		}
	 
	 @PostMapping("/update_category/{id}")
		public String saveupdate(@ModelAttribute("id") Category Category) {
			 System.out.println(Category);
			 CategoryRepository.save(Category);
			return "redirect:/categoryList";
		}
	 
	 //////////////////////////////
	 
	 @GetMapping("/update_product/{productId}")
		public String upproduct (@PathVariable("productId") int id , Model model) {
		 Product product = ProductRepository.findById(id)
					.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
			model.addAttribute("product",product);
					return "update_product";
		}
	 

	 
	 @PostMapping("/update_product/{productId}")
		public String saveupdateproduct(@ModelAttribute("productId") Product Product) {
			 System.out.println(Product);
			 ProductRepository.save(Product);
			return "redirect:/susses";
		}
	 
	 
	 ///delete_category/////
	 @GetMapping("/delete_category/{id}")
		public String delet (@PathVariable("id") int id , Model model) {
		 Category category = CategoryRepository.findById(id)
					.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
			model.addAttribute("category",category);
			System.out.println(id);
			CategoryRepository.deleteById(id);
					return "redirect:/susses";
		}
	 
	///delete_category/////
		 @GetMapping("/delete_product/{productId}")
			public String deletproduct (@PathVariable("productId") int id , Model model) {
			 Product product = ProductRepository.findById(id)
						.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
				model.addAttribute("category",product);
				System.out.println(id);
				ProductRepository.deleteById(id);
						return "redirect:/susses";
			}
		 
			///delete_Customer/////
		 @GetMapping("/delete_customer/{id_user}")
			public String deletcustomer (@PathVariable("customerId") int id , Model model) {
			 customer customer = CustomerRepository.findById(id)
						.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
				model.addAttribute("category",customer);
				System.out.println(id);
				CustomerRepository.deleteById(id);
						return "redirect:/susses";
			}
	 

		 //////user///
		 @GetMapping("/update_user/{id_user}")
			public String updateuser (@PathVariable("id_user") int id , Model model) {
				customer customer = CustomerRepository.findById(id)
						.orElseThrow(()-> new IllegalArgumentException("Invalid user id ; " + id));
				model.addAttribute("customer",customer);
						return "update_user";
			}
		 @PostMapping("/update_user/{id_user}")
			public String saveuser(@ModelAttribute("id_user") customer customer) {
				 System.out.println(customer);
				 CustomerRepository.save(customer);
				return "redirect:/susses";
			}
		 @GetMapping("/susses")
			public String test () {
						return "updateuser";
			}
		 
		 
		 
		 public class ProductController {

			    @GetMapping("/new_product")
			    public String showFormProduct(Model model) {
			        Product product = new Product();
			        model.addAttribute("product", product);
			        return "new_product";
			    }

			    @PostMapping("/new_product")
			    public String submitProduct(@ModelAttribute("product") Product product) {
			        // Save the product to the database
			        ProductRepository.save(product);

			        // Redirect to a success page or another appropriate view
			        return "redirect:/new_product_success";
			    }
			}
		 
		 
	
}
