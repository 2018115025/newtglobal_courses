package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.entity.Orders;
import com.masai.entity.Product;
import com.masai.exception.MyException;
import com.masai.repo.CustomerRepository;
import com.masai.repo.OrderRepository;
import com.masai.repo.ProductsRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	ProductsRepository productsrepo;
	
	@Override
	public Customer addCustomer(Customer c) {
		if(c==null) throw new MyException("try again later");
		return customerrepo.save(c);
	}

	@Override
	public Orders addOrder(Orders o) throws MyException {
		if(o==null) throw new MyException("try again later");
		List<Product> products=o.getProducts();
		Double sum=0.0;
		for(Product i:products) {
			sum+=i.getPrice();
		}
		o.setAmount(sum);
		return orderrepo.save(o);
	}

	@Override
	public Product addProduct(Product p) throws MyException {
		if(p==null) throw new MyException("try again later");
		return productsrepo.save(p);
	}

	@Override
	public Customer getCustomerById(Integer id) throws MyException {
		return customerrepo.findById(id).orElseThrow(()->new MyException("enter valid id"));
	}

	@Override
	public Page<Customer> getAllcus(Integer pagenumber,Integer numofpage,String sorttype) throws MyException {
		Pageable p=PageRequest.of(pagenumber-1, numofpage,Sort.by(sorttype).ascending());
		
		return customerrepo.findAll(p);
	}

	@Override
	public List<Customer> getCustomerByName(String name) throws MyException {
		List<Customer> c=customerrepo.getByName(name);
		if(c.isEmpty()) {
			throw new MyException("enter valid name");
		}
		return c;
	}

	@Override
	public Orders setProductById(Integer productid, Integer orderid) {
		Orders o=orderrepo.findById(orderid).orElseThrow(()->new MyException("enter valid id"));
		Product p=productsrepo.findById(productid).orElseThrow(()->new MyException("enter valid id"));
		o.getProducts().add(p);
		p.setMyorder(o);
		return orderrepo.save(o);
	}

	@Override
	public Customer getCustomerByEmail(String email) throws MyException {
		Optional<Customer> opt= customerrepo.findByEmail(email);
		if(opt.isEmpty()) {
			throw new MyException("enter valid mail");
		}
		else {
			return opt.get();
		}
	}

	@Override
	public List<Customer> getAllCustomer() throws MyException {
		return customerrepo.findAll();
	}
	
	

}
