package com.productosisis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productosisis.models.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}