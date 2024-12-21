package com.products.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.products.shop.repository.ProductRepository;
import com.products.shop.to.Product;

@Configuration
public class DataBaseSeeder {

	@Bean
	CommandLineRunner initDataBase(ProductRepository productRepository) {

		return args -> {
			productRepository.save(
					new Product(null, "NikSaNam", "Shirts", ImageConstants.IMAGE1, "Most Beautiful Shirt ever", true));
			productRepository.save(
					new Product(null, "ManPav", "Shirts", ImageConstants.IMAGE1, "Most Beautiful Shirt ever", true));
			productRepository
					.save(new Product(null, "Sid", "Shirts", ImageConstants.IMAGE1, "Most Beautiful Shirt ever", true));

		};
	}
}
