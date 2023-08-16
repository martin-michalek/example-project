package com.michalek.codingexample;

import com.michalek.codingexample.entity.User;
import com.michalek.codingexample.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class CodingExampleApplication {

    private final UserRepository userRepository;

    public CodingExampleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(CodingExampleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareDataForCustomerTable() {
        User user1 = new User();
        user1.setFirstName("Martin");
        user1.setLastName("Michalek");
        user1.setEmail("martinmichalek332@gmail.com");
        user1.setPassword("secretPassword");

        User user2 = new User();
        user2.setFirstName("Maik");
        user2.setLastName("Toward");
        user2.setEmail("maik.toward@test.com");
        user2.setPassword("secretsMaiksPassword");

        userRepository.saveAll(List.of(user1, user2));
    }

}
