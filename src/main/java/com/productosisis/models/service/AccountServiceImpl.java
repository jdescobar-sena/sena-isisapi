package com.productosisis.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productosisis.models.entity.Account;
import com.productosisis.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Optional<Account> findById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public void deleteById(Integer id) {
		accountRepository.deleteById(id);
	}

	@Override
	public String login(String email, String passwd) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByEmail(email);
		
		if (account == null) {
			return "{ 'Message': 'Account not found' }";
		}
		
		if (!account.getPassword().equals(passwd)) {
			return "{ 'Message': 'Incorrect password' }";
		}
		
		return "{ 'Message': 'Login successful' }";
	}
}
