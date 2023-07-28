/*
 * STEP 1
 * Primero se crean los paquetes que se van a usar:
 * security
 * models.entity
 * models.service
 * repository
 * controllers
 * Dentro del paquete models.entity se crearan las clases correspondientes con los modelos de base de datos del proyecto.
 */
package com.productosisis.models.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private long account_id;
	
	@Column(name = "document_id")
	private int document_id;
	
	@Column(name = "first_name")
    private String first_name;
	
	@Column(name = "last_name")
    private String last_name;
	
	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
    private Date birthdate;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "address")
    private String address;

	public Account() {
	}

	public Account(long account_id, int document_id, String first_name, String last_name, Date birthdate, String email,
			String password, String address) {
		super();
		this.account_id = account_id;
		this.document_id = document_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
