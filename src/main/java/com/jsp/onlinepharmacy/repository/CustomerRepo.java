package com.jsp.onlinepharmacy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacy.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	@Query("select c")
	public Optional<Customer> findByEmail(String email);

}
