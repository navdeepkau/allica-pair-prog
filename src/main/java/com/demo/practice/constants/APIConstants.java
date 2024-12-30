package com.demo.practice.constants;

public final class APIConstants {


    private APIConstants(){

    }
    public static final String BASE_URL = "/api/v1/user";

    public static final String CREATE_USER_RECORD ="/create" ;

    public static final String GET_USER_RECORD ="/get/{userId}" ;

    public static final String GET_PRODUCT_LIST ="/get/{userId}/products/details" ;

    public static final String USER_ID = "userId" ;
}