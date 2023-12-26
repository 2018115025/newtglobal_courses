package com.masai.config;



import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class MyConfiguration {
	
	@Bean
	public SecurityFilterChain sampleCOnfiguration(HttpSecurity http) throws Exception{
		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(cors -> {

			cors.configurationSource(new CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration cfg = new CorsConfiguration();

					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}
			});

		})
		
		.authorizeHttpRequests((auth)->{auth
			.requestMatchers(HttpMethod.POST,"/user").hasRole("admin")
			.requestMatchers(HttpMethod.GET,"/hello","/allusers").hasRole("admin")
			.requestMatchers(HttpMethod.GET,"/user/**").hasAnyRole("admin","user")
			.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			.anyRequest().authenticated();
		})
		.csrf(csrf->csrf.disable())
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(),BasicAuthenticationFilter.class)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	  UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//	    UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}

//	 @Bean
//	 public PasswordEncoder passwordEncoder() {
//	        return NoOpPasswordEncoder.getInstance();
//	 }

}
