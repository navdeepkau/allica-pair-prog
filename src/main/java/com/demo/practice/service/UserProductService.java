package com.demo.practice.service;

import com.demo.practice.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserProductService {

    ResponseEntity<List<Product>> getProductsForUser(String userId);
}
