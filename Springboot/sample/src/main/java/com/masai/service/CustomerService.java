package com.masai.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.masai.entity.Customer;
import com.masai.entity.Orders;
import com.masai.entity.Product;
import com.masai.exception.MyException;

public interface CustomerService {
	public Customer addCustomer(Customer c) throws MyException;
	public Orders addOrder(Orders o) throws MyException;
	public Product addProduct(Product p) throws MyException;
	public Customer getCustomerById(Integer id) throws MyException;
	public Customer getCustomerByEmail(String email) throws MyException;
	public Page<Customer> getAllcus(Integer pagenumber,Integer numofpage,String sorttype) throws MyException;
	public List<Customer> getAllCustomer() throws MyException;
	public List<Customer> getCustomerByName(String name) throws MyException;
	public Orders setProductById(Integer productid,Integer orderid);

}
