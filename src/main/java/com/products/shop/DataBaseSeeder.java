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
			productRepository.save(new Product(null, "NikSaNam", "shoes", "https://github.com/Nikhil-sai-nambula/e-commerce/blob/main/shirt1.jpg",
					"Most Beautiful Shoes ever", true));
			productRepository.save(new Product(null, "ManPav", "shoes", "https://github.com/Nikhil-sai-nambula/e-commerce/blob/main/shirt1.jpg",
					"Most Beautiful Shoes ever", true));
			productRepository.save(new Product(null, "Sid", "shoes", "https://github.com/Nikhil-sai-nambula/e-commerce/blob/main/shirt1.jpg", 
							"Most Beautiful Shoes ever", true));

		};
	}
}
