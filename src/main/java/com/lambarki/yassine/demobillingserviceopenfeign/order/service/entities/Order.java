package com.lambarki.yassine.demobillingserviceopenfeign.order.service.entities;


import com.lambarki.yassine.demobillingserviceopenfeign.order.service.enums.OrderStatus;
import com.lambarki.yassine.demobillingserviceopenfeign.order.service.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
        @Id @GeneratedValue(strategy = IDENTITY)
        private Long id;
        private Date createdAt;
        private OrderStatus status;
        private Long customerId;
        @Transient
        private Customer customer;
        @OneToMany(mappedBy = "order")
        private List<ProductItem> productItems;

        public double getTotal(){
            double somme=0;
            for(ProductItem pi:productItems){
                somme+=pi.getAmount();
            }
            return somme;
        }
}
