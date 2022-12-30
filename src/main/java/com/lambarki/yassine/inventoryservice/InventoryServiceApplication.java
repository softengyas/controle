package com.lambarki.yassine.inventoryservice;

import com.lambarki.yassine.inventoryservice.entities.Product;
import com.lambarki.yassine.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Product.class);
        return args -> {
          productRepository.save(new Product(null, "Ordinateur", 788,12));
          productRepository.save(new Product(null, "Imprimante", 88,120));
          productRepository.save(new Product(null, "Smartphone", 1288,60));

          productRepository.findAll().forEach(product -> {
              System.out.println(product.getName());
          });

        };
    }
}
