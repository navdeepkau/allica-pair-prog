package com.demo.practice.utils;


import com.demo.practice.entity.User;
import com.demo.practice.dto.UserDto;
import com.demo.practice.request.UserRequestDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserServiceUtil {

    /**
     * @Author Navdeep Kaur
     * Description Method converts incoming request into the equivalent dto
     * @param userRequestDto
     * @return
     */

    public UserDto convertUserRequestToDto(UserRequestDto userRequestDto){
        UserDto user = new UserDto();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setDateOfBirth(userRequestDto.getDateOfBirth());
        return user;
    }

    public User convertUserDtoToUserEntity(UserDto userDto){
        User user = new User();
        //Unique UUID is mapped here for every user
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        return user;
    }


}
