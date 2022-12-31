package com.lambarki.yassine.spring_cloud_gateway.repository;

import com.lambarki.yassine.spring_cloud_gateway.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @PreAuthorize("hasAuthority('USER')")
    @Override
    Optional<Customer> findById(Long id);
}
