package com.demo.practice.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper= true)
public class NoRecordFoundException extends RuntimeException {

    public NoRecordFoundException(String error) {
        super(error);
    }
}