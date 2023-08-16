package com.michalek.codingexample.enums;

public class RestConstants {

    private RestConstants() {
        // prevent from initialization
    }

    public static final String REST_V1 = "v1";
    public static final String USERS_REST = "/users";
    public static final String USERS_REST_GET_BY_ID = "/{id}";
    public static final String USERS_REST_GET_BY_EMAIL = "/email";
    public static final String USERS_REST_GET_BY_FIRST_AND_LAST_NAME = "/firstLastName";
    public static final String USERS_REST_SAVE_USER = "/save";
    public static final String USERS_REST_DELETE_USER = "/delete";
}
