package com.demo.practice.controller;


import com.demo.practice.constants.APIConstants;
import com.demo.practice.entity.Product;
import com.demo.practice.entity.User;
import com.demo.practice.entity.UserProductMapping;
import com.demo.practice.repository.ProductRepository;
import com.demo.practice.repository.UserProductMappingRepository;
import com.demo.practice.request.UserRequestDto;
import com.demo.practice.service.UserProductService;
import com.demo.practice.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.demo.practice.constants.APIConstants.USER_ID;

@RestController
@Validated
@RequestMapping(value= "/api/v1/test")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    UserProductService userProductService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserProductMappingRepository userProductMappingRepository;


    /**
     * @author Navdeep Kaur
     * @Description Api endpoint to create user Record
     * @return
     */
    @PostMapping(value= "/create/mapping/{userId}/{productId}")
    public ResponseEntity<UserProductMapping> createCustomer(@PathVariable String userId,
                                               @PathVariable String productId){
        UserProductMapping userProductMapping = UserProductMapping.builder().id(String.valueOf(UUID.randomUUID()))
                .productId(productId).userId(userId).build();
        userProductMappingRepository.save(userProductMapping);
        return ResponseEntity.status(HttpStatus.CREATED).body(userProductMapping);
    }

    @PostMapping(value= "/creates" )
           // consumes= MediaType.APPLICATION_JSON_VALUE
           // produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createCustomer(@RequestParam String productName){
        Product product = Product.builder().productId(String.valueOf(UUID.randomUUID())).productName(productName).build();
        Product productS = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productS);
    }

    @GetMapping (value= APIConstants.GET_PRODUCT_LIST , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsForUser(@PathVariable String userId) {
        return userProductService.getProductsForUser(userId);
    }

    @GetMapping (value= "/get/product/{productName}")
    public ResponseEntity<Product> getProductsForUsers(@PathVariable String productName) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.findByProductName(productName));
    }

    @PostMapping(value= "/create" ,
            //consumes= MediaType.APPLICATION_JSON_VALUE ,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createUser(@RequestParam String productName){
        Product product = productRepository.save(createProduct(productName));
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    private Product createProduct(String productName) {
        Product user = new Product();
        //Unique UUID is mapped here for every user
        user.setProductId(String.valueOf(UUID.randomUUID()));
        user.setProductName(productName);
        return user;
    }
}
