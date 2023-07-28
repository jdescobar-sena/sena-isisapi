/*
 * PASO 5
 * En el paquete service se deben crear
 * las interfaces donde se declaran los
 * métodos que contienen la lógica.
 */
package com.productosisis.models.service;

import java.util.List;
import java.util.Optional;

import com.productosisis.models.entity.Product;

public interface ProductService {
	public Optional<Product> findById(Long id);
	public List<Product> findAll();
	public Product save(Product p);
	public void deleteById(Long id);
}
