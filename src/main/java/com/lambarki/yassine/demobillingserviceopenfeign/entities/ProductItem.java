package com.lambarki.yassine.demobillingserviceopenfeign.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambarki.yassine.demobillingserviceopenfeign.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_WRITE;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private int quantity;
    private double price;
    private long productId;
    @JsonProperty(access = WRITE_ONLY)
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
