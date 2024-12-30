//package com.demo.practice.controller;
//
//import com.demo.practice.entitty.Product;
//import com.demo.practice.entitty.User;
//import com.demo.practice.request.UserRequestDto;
//import com.demo.practice.service.UserProductService;
//import com.demo.practice.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private UserProductService userProductService;
//
//    private User user;
//    private Product product;
//    private UserRequestDto userRequestDto;
//
//    @BeforeEach
//    public void setUp() {
//        // Set up mock data for testing
//
//        // Create a mock User object
//        user = new User(1L, "John", "Doe",null,null);
//
//        // Create a mock Product object
//        product = new Product(1L, "Product1", "Product description", true, null, null);
//
//    }
//
//    @Test
//    public void testCreateUser() throws Exception {
//        // Mock the service call to create a user
//        when(userService.createUserRecord(any(UserRequestDto.class))).thenReturn(ResponseEntity.ok(user));
//
//        // Send POST request and assert response
//        mockMvc.perform(post("/api/users/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"firstName\": \"John\", \"lastName\": \"Doe\", \"dateOfBirth\": \"1990-01-01\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value("John"))
//                .andExpect(jsonPath("$.lastName").value("Doe"));
//    }
//
//    @Test
//    public void testGetUserDetails() throws Exception {
//        // Mock the service call to get user details
//        when(userService.getUserDetails(anyLong())).thenReturn(ResponseEntity.ok(user));
//
//        // Send GET request and assert response
//        mockMvc.perform(get("/api/users/1/details"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value("John"))
//                .andExpect(jsonPath("$.lastName").value("Doe"));
//    }
//
//    @Test
//    public void testGetProductsForUser() throws Exception {
//        // Mock the service call to get products for the user
//        List<Product> products = Arrays.asList(product);
//        when(userProductService.getProductsForUser(anyLong())).thenReturn(ResponseEntity.ok(products));
//
//        // Send GET request and assert response
//        mockMvc.perform(get("/api/users/1/products"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].productName").value("Product1"))
//                .andExpect(jsonPath("$[0].metadata").value("Product description"));
//    }
//}
