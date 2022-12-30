package com.lambarki.yassine.demobillingserviceopenfeign.order.service.models;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
