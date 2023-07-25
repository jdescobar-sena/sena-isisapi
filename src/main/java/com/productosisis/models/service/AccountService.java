package com.productosisis.models.service;

import java.util.List;
import java.util.Optional;

import com.productosisis.models.entity.Account;

public interface AccountService {
	public Optional<Account> findById(Integer id);
	public List<Account> findAll();
	public Account save(Account a);
	public void deleteById(Integer id);
}
