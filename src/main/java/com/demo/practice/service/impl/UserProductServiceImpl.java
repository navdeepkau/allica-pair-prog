package com.demo.practice.service.impl;

import com.demo.practice.entity.Product;
import com.demo.practice.entity.UserProductMapping;
import com.demo.practice.repository.UserProductMappingRepository;
import com.demo.practice.repository.ProductRepository;
import com.demo.practice.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    private UserProductMappingRepository userProductMappingRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * @author Navdeep kaur
     * @Description Service method to process incoming userId request into business logic
     * Returns product details per userId
     * @param userId
     * @return
     */
    // Get a list of products for a given userId
    public ResponseEntity<List<Product>> getProductsForUser(String userId) {
        // Get all mappings for the given userId
        List<UserProductMapping> userProductMappings = userProductMappingRepository.findByUserId(userId);

        // Extract productIds from the mappings
        List<String> productIds = userProductMappings.stream()
                .map(UserProductMapping::getProductId)
                .collect(Collectors.toList());

        // Fetch all products using the productIds
        List<Product> products =  productRepository.findAllById(productIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);

    }
}
