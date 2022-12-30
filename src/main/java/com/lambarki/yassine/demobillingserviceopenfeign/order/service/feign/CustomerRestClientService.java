package com.lambarki.yassine.demobillingserviceopenfeign.order.service.feign;

import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id);
    @GetMapping("/customers")
    public PagedModel<Customer> allCustomers();
}
