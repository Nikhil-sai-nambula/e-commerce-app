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
					new Product(null, "NikSaNam","100% pure cotton", "M_Shirts", ImageConstants.IMAGE1, "Most Beautiful Shirt ever", true));
			productRepository.save(
					new Product(null, "ManPav","100% pure cotton", "M_Shirts", ImageConstants.IMAGE2, "Most Beautiful Shirt ever", true));
			productRepository
					.save(new Product(null, "Sid","100% pure cotton", "M_Shirts", ImageConstants.IMAGE3, "Most Beautiful Shirt ever", true));
			productRepository
			.save(new Product(null, "Sid","100% pure cotton", "M_Shirts", ImageConstants.IMAGE4, "Most Beautiful Shirt ever", true));

		};
	}
}
