package com.lambarki.yassine.demobillingserviceopenfeign.order.service.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
