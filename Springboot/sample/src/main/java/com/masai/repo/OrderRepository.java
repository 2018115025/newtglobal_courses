package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
