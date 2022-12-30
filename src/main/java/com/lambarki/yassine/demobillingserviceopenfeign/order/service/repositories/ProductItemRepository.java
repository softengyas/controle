package com.lambarki.yassine.demobillingserviceopenfeign.order.service.repositories;

import com.lambarki.yassine.demobillingserviceopenfeign.order.service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}