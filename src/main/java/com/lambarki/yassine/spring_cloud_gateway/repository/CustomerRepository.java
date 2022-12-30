package com.lambarki.yassine.spring_cloud_gateway.repository;

import com.lambarki.yassine.spring_cloud_gateway.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
