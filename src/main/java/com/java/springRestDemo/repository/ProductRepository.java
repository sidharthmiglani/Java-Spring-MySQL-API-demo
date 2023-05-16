package com.java.springRestDemo.repository;

import com.java.springRestDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByName(String name);
}
