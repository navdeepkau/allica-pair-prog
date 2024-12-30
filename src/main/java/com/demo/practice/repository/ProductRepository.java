package com.demo.practice.repository;

import com.demo.practice.entity.Product;
import com.demo.practice.entity.UserProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findByProductName(String productName);

}
