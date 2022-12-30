package com.lambarki.yassine.demobillingserviceopenfeign.web;

import com.lambarki.yassine.demobillingserviceopenfeign.entities.Bill;
import com.lambarki.yassine.demobillingserviceopenfeign.feign.CustomerRestClient;
import com.lambarki.yassine.demobillingserviceopenfeign.feign.ProductItemRestClient;
import com.lambarki.yassine.demobillingserviceopenfeign.models.Customer;
import com.lambarki.yassine.demobillingserviceopenfeign.models.Product;
import com.lambarki.yassine.demobillingserviceopenfeign.repositories.BillRepository;
import com.lambarki.yassine.demobillingserviceopenfeign.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor

public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
       Bill bill = billRepository.findById(id).get();
        Customer customerById = customerRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customerById);
        bill.getProductItems().forEach(productItem -> {
            Product p = productItemRestClient.getProductById(productItem.getProductId());
            productItem.setProduct(p);
        });
       return bill;
    }
}
