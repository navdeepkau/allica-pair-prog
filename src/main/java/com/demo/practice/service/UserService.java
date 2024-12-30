package com.demo.practice.service;

import com.demo.practice.entity.User;
import com.demo.practice.request.UserRequestDto;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> createUserRecord(UserRequestDto request);

    ResponseEntity<User> getUserDetails(String userId) throws BadRequestException;
}
