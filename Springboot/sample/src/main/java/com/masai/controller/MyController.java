package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Customer;
import com.masai.entity.Orders;
import com.masai.entity.Product;
import com.masai.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class MyController {
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	PasswordEncoder PasswordEncoder;
	
	@GetMapping("/hello")
	public ResponseEntity<String> testhandler(){
		return new ResponseEntity<String>("welcome ", HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Customer> addCusHandler(@Valid @RequestBody Customer c){
		c.setPassword(PasswordEncoder.encode(c.getPassword()));
		c.setRole("ROLE_"+c.getRole());
		Customer cus= customerservice.addCustomer(c);
		return new ResponseEntity<>(cus, HttpStatus.ACCEPTED);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getCusByIdHandler(@PathVariable Integer id){
		Customer cus= customerservice.getCustomerById(id);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
	@GetMapping("/userbyname/{name}")
	public ResponseEntity<List<Customer>> getCusBynameHandler(@PathVariable String name){
		List<Customer> cus= customerservice.getCustomerByName(name);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
	@GetMapping("/alluser/{p}/{size}")
	public ResponseEntity<List<Customer>> getAllCusHandler(@PathVariable Integer p,@PathVariable Integer size,@RequestParam String type){
		Page<Customer> cus= customerservice.getAllcus(p,size,type);
		return new ResponseEntity<>(cus.getContent(), HttpStatus.OK);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<Customer>> getAllCusHtomerandler(){
		List<Customer> cus= customerservice.getAllCustomer();
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrderHandler(@Valid @RequestBody Orders o){
		Orders cus= customerservice.addOrder(o);
		return new ResponseEntity<>(cus, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> addOrderHandler(@Valid @RequestBody Product p){
		Product cus= customerservice.addProduct(p);
		return new ResponseEntity<>(cus, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/user/{productid}/{orderid}")
	public ResponseEntity<Orders> setOrderHandler(@PathVariable Integer productid,@PathVariable Integer orderid){
		Orders cus= customerservice.setProductById(productid, orderid);
		return new ResponseEntity<>(cus, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<String> signIn(Authentication auth){
		System.out.println(auth.getName());
		Customer c= customerservice.getCustomerByEmail(auth.getName());
		String ans=c.getName()+" logged in sucusfully";
		return new ResponseEntity<String>(ans, HttpStatus.OK);
	}

}
