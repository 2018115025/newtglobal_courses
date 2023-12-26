package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.entity.Customer;
import com.masai.entity.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
//	@Query("select c.id,c.name,email,orderdate,p.name from customer c join orders o on c.id=o.customer_id join product p on o.orderid=p.order_id")
	
}
