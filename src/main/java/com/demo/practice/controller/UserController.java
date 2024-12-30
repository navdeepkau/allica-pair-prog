package com.demo.practice.controller;


import com.demo.practice.constants.APIConstants;
import com.demo.practice.entity.Product;
import com.demo.practice.entity.User;
import com.demo.practice.request.UserRequestDto;
import com.demo.practice.service.UserProductService;
import com.demo.practice.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.demo.practice.constants.APIConstants.USER_ID;

@RestController
@Validated
@RequestMapping(value= APIConstants.BASE_URL)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserProductService userProductService;


    /**
     * @author Navdeep Kaur
     * @Description Api endpoint to create user Record
     * @param request
     * @return
     */
    @PostMapping(value= APIConstants.CREATE_USER_RECORD ,
            consumes= MediaType.APPLICATION_JSON_VALUE ,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto request){
        return userService.createUserRecord(request);
    }


    /**
     * @author Navdeep Kaur
     * @Description Api endpoint to get user Record based on userId
     * @param userId
     * @return
     */
    @GetMapping (value= APIConstants.GET_USER_RECORD , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserRecord(@PathVariable (USER_ID) String userId) throws BadRequestException {
        return userService.getUserDetails(userId);
    }

    /**
     * @author Navdeep Kaur
     * @Description Api endpoint to get Product details list based on userId
     * @param userId
     * @return
     */

    @GetMapping (value= APIConstants.GET_PRODUCT_LIST , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsForUser(@PathVariable String userId) {
        return userProductService.getProductsForUser(userId);
    }
}
