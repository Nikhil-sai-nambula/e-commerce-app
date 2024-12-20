package com.products.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.products.shop.repository.ProductRepository;
import com.products.shop.to.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProducByCategory(@PathVariable String category) {
		return productRepository.findByCategory(category);
	}

	public String saveProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Persisted Successfully";
	}

	public String  deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Deleted SuccessFully";
	}

}
