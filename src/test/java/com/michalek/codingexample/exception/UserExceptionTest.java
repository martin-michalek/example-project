package com.michalek.codingexample.exception;

import com.michalek.codingexample.enums.UserExceptionErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserExceptionTest {

    @Test
    public void GIVEN_data_WHEN_creating_exception_THEN_exception_created() {
        //GIVEN
        final String message = "Error message";
        final RuntimeException runtimeException = new RuntimeException();

        //WHEN
        UserException userException = new UserException(message, UserExceptionErrorCode.USER_NOT_FOUND);
        UserException userExceptionWithThrowable = new UserException(message, UserExceptionErrorCode.USER_NOT_FOUND, runtimeException);

        //THEN
        Assertions.assertThat(userException).isNotNull();
        Assertions.assertThat(userException.getMessage()).isEqualTo(message);
        Assertions.assertThat(userExceptionWithThrowable).isNotNull();
        Assertions.assertThat(userExceptionWithThrowable.getMessage()).isEqualTo(message);
    }

}