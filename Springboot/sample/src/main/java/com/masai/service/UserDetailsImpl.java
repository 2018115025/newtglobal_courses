package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.repo.CustomerRepository;

@Service
public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	CustomerRepository customerrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> opt= customerrepo.findByEmail(username);

		if(opt.isPresent()) {
			
			Customer customer= opt.get();
			
			//Empty Authorities
			List<GrantedAuthority> authorities= new ArrayList<>();
//			List<String> auth=customer.getAuth();
//			for(String s:auth) {
//				authorities.add(new SimpleGrantedAuthority(s));
//			}
			authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			
			
			return new User(customer.getEmail(), customer.getPassword(), authorities);
			
			//return new CustomerUserDetails(customer);
			
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
	}

}
