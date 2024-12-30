package com.demo.practice.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
@EqualsAndHashCode(callSuper= true)
public class InvalidRequestException  extends RuntimeException {

    public InvalidRequestException(String error){
        super(error);
    }
}