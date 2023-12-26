package com.masai.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "name not null")
	private String name;
	@Column(unique = true)
	@Email(message = "email cannot be null")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String role;
//	@ElementCollection
//	@CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "id"))
//	private List<String> auth;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	List<Orders> orders=new ArrayList<>();

}
