package com.demo.practice.service.impl;

import com.demo.practice.constants.ExceptionConstants;
import com.demo.practice.entity.User;
import com.demo.practice.dto.UserDto;
import com.demo.practice.exceptions.InvalidRequestException;
import com.demo.practice.exceptions.NoRecordFoundException;
import com.demo.practice.repository.UserRepository;
import com.demo.practice.request.UserRequestDto;
import com.demo.practice.service.UserService;
import com.demo.practice.utils.UUIDHelper;
import com.demo.practice.utils.UserServiceUtil;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.Optional;
import java.util.UUID;

import static com.demo.practice.constants.ExceptionConstants.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceUtil userServiceUtil;


    /**
     * @author Navdeep kaur
     * @Description Service method to process incoming request into business logic
     * Creates new customer record in database
     * @param request
     * @return
     */
    @Override
    public ResponseEntity<User> createUserRecord(UserRequestDto request) {
        isValidRequest(request);
        UserDto userDto = userServiceUtil.convertUserRequestToDto(request);
        User user = userServiceUtil.convertUserDtoToUserEntity(userDto);
        /**
         * Skipping validation because of no clear requirement related to that
         * can be introduced here at later stage based of validation requirement
         */
        User userEntity = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }

    /**
     * @author Navdeep Kaur
     * @Description Service method to process incoming request into business logic
     * Fetches customer record from database
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity<User> getUserDetails(String userId) throws BadRequestException {
        if(ObjectUtils.isEmpty(userId)){
            throw new BadRequestException(INVALID_UUID);
        }
        isValidUUID(userId);
        Optional<User> userEntity = userRepository.findById(userId);
        if(ObjectUtils.isEmpty(userEntity) || userEntity.isEmpty()){
            throw new NoRecordFoundException(NO_RECORD_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userEntity.get());
    }


    /**
     * @description Check if request is Empty
     * @param request
     * @throws InvalidRequestException
     */
    private void isValidRequest(UserRequestDto request)  {
        if(ObjectUtils.isEmpty(request)|| (ObjectUtils.isEmpty(request.getDateOfBirth()))
                ||(ObjectUtils.isEmpty(request.getFirstName()))||(ObjectUtils.isEmpty(request.getLastName()))){
            throw new InvalidRequestException(ExceptionConstants.BAD_REQUEST);
        }
    }

    private void isValidUUID(String customerId) {
        UUIDHelper.validateUuid(customerId, INVALID_UUID);
    }
}
