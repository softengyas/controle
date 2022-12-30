package com.lambarki.yassine.demobillingserviceopenfeign;

import com.lambarki.yassine.demobillingserviceopenfeign.entities.Bill;
import com.lambarki.yassine.demobillingserviceopenfeign.entities.ProductItem;
import com.lambarki.yassine.demobillingserviceopenfeign.feign.CustomerRestClient;
import com.lambarki.yassine.demobillingserviceopenfeign.feign.ProductItemRestClient;
import com.lambarki.yassine.demobillingserviceopenfeign.models.Customer;
import com.lambarki.yassine.demobillingserviceopenfeign.models.Product;
import com.lambarki.yassine.demobillingserviceopenfeign.repositories.BillRepository;
import com.lambarki.yassine.demobillingserviceopenfeign.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class DemoBillingServiceOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBillingServiceOpenFeignApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        return args -> {
            Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill1 = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
            PagedModel<Product> productPagedModel = productItemRestClient.pageProducts();
            productPagedModel.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(product.getPrice());
                productItem.setQuantity(new Random().nextInt(100));
                productItem.setBill(bill1);
                productItem.setProductId(product.getId());
                productItemRepository.save(productItem);
            });
        };
    }
}
