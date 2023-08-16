package com.michalek.codingexample.repository;

import com.michalek.codingexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<List<User>> findByEmail(String email);
}
