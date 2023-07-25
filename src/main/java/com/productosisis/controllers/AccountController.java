package com.productosisis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productosisis.models.entity.Account;
import com.productosisis.models.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/{id}")
	public Optional<Account> findById(@PathVariable Integer id) {
		return accountService.findById(id);
	}
	
	@GetMapping("/list")
	public List<Account> listAll() {
		return accountService.findAll();
	}
	
	@PostMapping
	public Account save(@RequestBody Account a) {
		return accountService.save(a);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		accountService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Account update(@RequestBody Account a, @PathVariable Integer id) {
		Account existingAccount = accountService.findById(id).get();
		
		existingAccount.setFirstName(a.getFirstName());
		existingAccount.setLastName(a.getLastName());
		
		// como entrará la fecha aca? en jsp se entra así: "yyyy-MM-dd"
		existingAccount.setBirthdate(a.getBirthdate());
		
		existingAccount.setEmail(a.getEmail());
		existingAccount.setPassword(a.getPassword());
		existingAccount.setAddress(a.getAddress());
		
		return accountService.save(existingAccount);
	}
	
	
}
