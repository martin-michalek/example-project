package com.michalek.codingexample.controller;

import net.minidev.json.JSONUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * For the user controller test I've created simple integration test
 * where I received a list of all users
 */
@ExtendWith(SpringExtension.class)
class UserControllerIT {

    private static final String LOCALHOST = "http://localhost:8080";

    @Test
    public void GIVEN_example_request_made_WHEN_response_received_THEN_response_ok() throws IOException {
        // GIVEN
        HttpUriRequest request = new HttpGet(LOCALHOST + "/v1/users");

        // WHEN
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // THEN
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());

        String responseString = EntityUtils.toString(httpResponse.getEntity());
        assertThat(responseString).contains("Martin");
        assertThat(responseString).contains("Michalek");
        assertThat(responseString).contains("martinmichalek332@gmail.com");
    }
}