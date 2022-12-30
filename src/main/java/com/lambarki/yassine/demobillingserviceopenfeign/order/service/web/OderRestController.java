package com.lambarki.yassine.demobillingserviceopenfeign.order.service.web;


import com.lambarki.yassine.demobillingserviceopenfeign.order.service.entities.Order;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.feign.CustomerRestClientService;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.feign.InventoryRestClientService;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Customer;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Product;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.repositories.OrderRepository;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.repositories.ProductItemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@AllArgsConstructor
public class OderRestController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
