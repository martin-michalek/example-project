package com.michalek.codingexample.entity;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


class UserTest {

    @Test
    public void assertThatEntityIsCorrect() {
        User user = new User();

        user.setFirstName("Martin");
        user.setLastName("Michalek");
        user.setEmail("martinmichalek332@gmail.com");
        user.setPassword("pwdSecretPssth");
        user.setId(1L);

        assertThat(user, Matchers.allOf(
                Matchers.hasProperty("firstName"),
                Matchers.hasProperty("lastName"),
                Matchers.hasProperty("email"),
                Matchers.hasProperty("id"),
                Matchers.hasProperty("password"),
                Matchers.hasToString(Matchers.any(String.class))
        ));
    }
}