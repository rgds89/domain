package com.devsuperior.domain;

import com.devsuperior.domain.entities.Client;
import com.devsuperior.domain.entities.Product;
import com.devsuperior.domain.repositories.ClientRepository;
import com.devsuperior.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Alex Green", "alex@gmail.com");
		clientRepository.save(c1);

		Product p1 = new Product(null, "TV", 1000.00);
		productRepository.save(p1);
	}

}
