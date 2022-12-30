package com.lambarki.yassine.demobillingserviceopenfeign.order.service;

import com.lambarki.yassine.demobillingserviceopenfeign.order.service.entities.Order;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.entities.ProductItem;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.enums.OrderStatus;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.feign.CustomerRestClientService;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.feign.InventoryRestClientService;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Customer;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Product;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.repositories.OrderRepository;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class DemoOrderServiceOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOrderServiceOpenFeignApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService){
        return args -> {
            List<Customer> customers=customerRestClientService.allCustomers().getContent().stream().toList();
            List<Product> products=inventoryRestClientService.allProducts().getContent().stream().toList();
            System.out.println(products +" & "+  customers);
            Long customerId=1L;
            Random random=new Random();
            Customer customer=customerRestClientService.customerById(customerId);
            for (int i = 0; i <20 ; i++) {
                Order order=Order.builder()
                        .customerId(customers.get(random.nextInt(customers.size())).getId())
                        .status(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CREATED)
                        .createdAt(new Date())
                        .build();
                Order savedOrder = orderRepository.save(order);
                System.out.println("---------------");
                System.out.println(savedOrder);
                for (int j = 0; j < products.size() ; j++) {
                    if(Math.random()>0.70){
                        ProductItem productItem=ProductItem.builder()
                                .order(savedOrder)
                                .productId(products.get(j).getId())
                                .price(products.get(j).getPrice())
                                .quantity(1+random.nextInt(10))
                                .discount(Math.random())
                                .build();
                        //productItemRepository.save(productItem);
                        ProductItem save = productItemRepository.save(productItem);

                        System.out.println("---------------");
                        System.out.println(save);
                    }

                }
            }
        };
    }
}