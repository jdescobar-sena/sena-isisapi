/**
 * PASO 6
 * En el paquete services también se deben crear
 * las clases que implementen las interfaces
 * anteriormente creadas, en estas clases se
 * aplicará la lógica a los métodos.
 * 
 * Se deben realizar las siguientes modificaciones:
 * 
 * 1. Sobre el nombre de la clase se debe
 * colocar la etiqueta @Service.
 * 
 * 2. Crear un atributo de tipo
 * entidadRepository inyectando dependencia
 * al colocar la etiqueta @autowired.
 * 
 * 3. Utilizar el atributo entidadRepository en la
 * implementación de cada método.
 */
package com.productosisis.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productosisis.models.entity.Product;
import com.productosisis.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	
	@Override
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product p) {
		return productRepository.save(p);
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
}
