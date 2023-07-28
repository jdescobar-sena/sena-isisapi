/*
 * PASO 1
 * Primero se crean los paquetes que se van a usar:
 * security
 * models.entity
 * models.service
 * repository
 * controllers
 * Dentro del paquete models.entity se crearan las clases correspondientes con los modelos de base de datos del proyecto.
 * 
 * # PASO 2
 * Crear en src\main\resources\application.properties la conexión a la base de datos
 */

package com.productosisis.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * PASO 3
 * Se crean cada uno de los atributos de acuerdo a la base de datos y se les 
 * aplica mapeo JPA con las etiquetas correspondientes.
 */

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long product_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "description", length = 65535)
	private String description;

	public Product() {
		
	}

	public Product(Long product_id, String name, float price, String description) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
