package com.michalek.codingexample.exception;

import com.michalek.codingexample.enums.UserExceptionErrorCode;

public class UserException extends RuntimeException {

    public final UserExceptionErrorCode userExceptionErrorCode;

    public UserException(String message, UserExceptionErrorCode errorCode) {
        super(message);
        userExceptionErrorCode = errorCode;
    }

    public UserException(String message, UserExceptionErrorCode errorCode, Throwable cause) {
        super(message, cause);
        userExceptionErrorCode = errorCode;
    }
}
