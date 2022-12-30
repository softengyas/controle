package com.lambarki.yassine.spring_cloud_gateway;

import com.lambarki.yassine.spring_cloud_gateway.entities.Customer;
import com.lambarki.yassine.spring_cloud_gateway.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SpringGloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringGloudGatewayApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null, "Mouad", "mouad@gmail.com"));
            customerRepository.save(new Customer(null, "Yassine", "yassine@gmail.com"));
            customerRepository.save(new Customer(null, "Salim", "salim@gmail.com"));

            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.toString());
            });
        };
    }
}
