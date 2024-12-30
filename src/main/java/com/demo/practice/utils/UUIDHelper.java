package com.demo.practice.utils;
import com.demo.practice.exceptions.InvalidRequestException;

import java.util.UUID;

public class UUIDHelper {

    private UUIDHelper(){

    }

    public static void validateUuid(String uuid , String error){
        try{
            UUID.fromString(uuid);
        }catch(Exception e){
            throw new InvalidRequestException(error);
        }
    }
}

