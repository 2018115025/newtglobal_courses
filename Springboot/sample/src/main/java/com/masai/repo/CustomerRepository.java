package com.masai.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>,PagingAndSortingRepository<Customer, Integer>{
	@Query("select c from Customer c where name like :s% ")
	public List<Customer> getByName(String s);
	
	public Optional<Customer> findByEmail(String email);
}
