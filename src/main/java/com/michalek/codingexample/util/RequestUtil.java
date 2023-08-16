package com.michalek.codingexample.util;

import com.michalek.codingexample.enums.UserExceptionErrorCode;
import com.michalek.codingexample.exception.UserException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class RequestUtil {

    public static void guardRequestData(String... values) {
        Arrays.asList(values).forEach(value -> {
            if(StringUtils.isEmpty(value)) {
                throw new UserException("Provided data are not valid! Please correct your inputs", UserExceptionErrorCode.INVALID_DATA);
            }
        });
    }
}
