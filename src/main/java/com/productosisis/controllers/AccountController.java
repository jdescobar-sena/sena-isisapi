package com.productosisis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productosisis.models.entity.Account;
import com.productosisis.models.service.AccountService;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin( origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT } )
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
		
		existingAccount.setDocument_id(a.getDocument_id());
		existingAccount.setFirst_name(a.getFirst_name());
		existingAccount.setLast_name(a.getLast_name());
		
		// how does the date come in? In jsp we put it like this: "yyyy-MM-dd"
		existingAccount.setBirthdate(a.getBirthdate());
		
		existingAccount.setEmail(a.getEmail());
		existingAccount.setPassword(a.getPassword());
		existingAccount.setAddress(a.getAddress());
		
		return accountService.save(existingAccount);
	}
	
	@PutMapping("/login")
	public ResponseEntity<String> login(@RequestBody Account account) {
		String message = accountService.login(account.getEmail(), account.getPassword());
		return ResponseEntity.ok(message);
	}
}
