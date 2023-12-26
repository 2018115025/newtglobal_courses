package com.masai.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

@Data
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderdate;
	@DecimalMin("0.0")
	private Double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@OneToMany(mappedBy = "myorder" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	List<Product> products=new ArrayList<>();

}
