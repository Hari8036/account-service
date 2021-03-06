package com.kcsitglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.entity.Customer;
import com.kcsitglobal.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer newCustomer=customerService.save(customer);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>>getCustomers(){
		List<Customer>customers=customerService.getCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		
	}
	
	@GetMapping("/customers/{id}")
    public ResponseEntity<Customer>getCustomerById(@PathVariable("id")int id){
		Customer newCustomer=customerService.getCustomerById(id).orElse(null);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.OK);
		
	}
}
