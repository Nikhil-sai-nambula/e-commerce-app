package com.products.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.shop.service.ProductService;
import com.products.shop.to.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products/all")
	private ResponseEntity<List<Product>> getAll() {
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{category}")
	private ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
		List<Product> products = productService.getProducByCategory(category);
		if (products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(products);
	}

	@PostMapping("/products/{product}")
	private ResponseEntity<String> saveProduct(@RequestBody Product product) {
		if (productService.saveProduct(product) == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok("Persisted Successfully");
	}

	@PostMapping("/products/{id}")
	private ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		if (productService.deleteProduct(id) == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok("Deleted Successfully");
	}

}
