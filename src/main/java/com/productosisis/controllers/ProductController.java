/**
 * PASO 7
 * Clases Controladoras:
 * Estas clases tienen como objetivo principal de
 * conectar el backend con las solicitudes que se
 * hagan desde afuera de la aplicación(sistemas
 * web, unirest, entre otros), esta tarea se realiza
 * a través del establecimiento de rutas.
 */
package com.productosisis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.productosisis.models.entity.Product;
import com.productosisis.models.service.ProductService;

@RestController
@RequestMapping("api/products")
@CrossOrigin( origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT } )
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public Optional<Product> findById(@PathVariable Long id) {
		return productService.findById(id);
	}
	
	@GetMapping("/list")
	public List<Product> listAll() {
		return productService.findAll();
	}
	
	@PostMapping
	public Product save(@RequestBody Product p) {
		return productService.save(p);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product p, @PathVariable Long id) {
		
		Product existingProduct = productService.findById(id).get();
		
		existingProduct.setName(p.getName());
		existingProduct.setPrice(p.getPrice());
		existingProduct.setDescription(p.getDescription());
		
		return productService.save(existingProduct);
	}
}
