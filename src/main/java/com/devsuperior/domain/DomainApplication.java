package com.devsuperior.domain;

import com.devsuperior.domain.entities.Client;
import com.devsuperior.domain.entities.Order;
import com.devsuperior.domain.entities.OrderStatus;
import com.devsuperior.domain.entities.Product;
import com.devsuperior.domain.repositories.ClientRepository;
import com.devsuperior.domain.repositories.OrderRepository;
import com.devsuperior.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Alex Green", "alex@gmail.com");
		clientRepository.save(c1);

		Product p1 = new Product(null, "TV", 1000.00);
		Product p2 = new Product(null, "Mouse", 40.0);
		Product p3 = new Product(null, "PC", 1200.0);
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		Order o1 = new Order(null, Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2021-04-20T13:30:00Z"), OrderStatus.WAITING, c1);
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}

}
