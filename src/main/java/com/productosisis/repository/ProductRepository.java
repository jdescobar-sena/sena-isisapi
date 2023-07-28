/*
 * PASO 4
 * Se debe crear por cada una de las
 * entidades una interface de nombre
 * entidadRepository.
 */
package com.productosisis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productosisis.models.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
