package com.lambarki.yassine.demobillingserviceopenfeign.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
