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
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/getAllCustomers")
	public String getAllCustomers(Model model) {
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return "customerDetails";
	}

	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		if(customer.getId() == 0) {
			customerService.addCustomer(customer);
		}
		else customerService.updateCustomer(customer);
		
		return "redirect:/getAllCustomers";
	}
	
	@GetMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getCustomer(id));
		model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
		
		return "customerDetails";
	}
	
	@GetMapping("/deleteCustomer/{id}")

	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getAllCustomers";
	}

}
