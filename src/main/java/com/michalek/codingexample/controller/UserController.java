package com.michalek.codingexample.controller;

import com.michalek.codingexample.entity.User;
import com.michalek.codingexample.exception.UserException;
import com.michalek.codingexample.service.UserService;
import com.michalek.codingexample.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.michalek.codingexample.enums.RestConstants.*;

@RestController
@RequestMapping(REST_V1 + USERS_REST)
@Slf4j
public class UserController {
    
    private static final String ERROR_LOG = "Searching for user failed! Error message=";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(USERS_REST_GET_BY_ID)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        if(id != null) {
            try {
                User user = userService.getUserById(id);
                return ResponseEntity.ok(user);
            } catch (UserException userException) {
                log.error(ERROR_LOG + userException.getMessage(), userException);
            }
        }

        return null;
    }

    @GetMapping(USERS_REST_GET_BY_EMAIL)
    public List<User> getUserByEmail(@RequestParam String email) {
        try {
            RequestUtil.guardRequestData(email);
            return userService.getUserByEmail(email);
        } catch (UserException userException) {
            log.error(ERROR_LOG + userException.getMessage(), userException);
        }

        return null;
    }

    @GetMapping(USERS_REST_GET_BY_FIRST_AND_LAST_NAME)
    public ResponseEntity<List<User>> getUserByNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        try {
            RequestUtil.guardRequestData(firstName, lastName);
            List<User> usersByName = userService.getUserByName(firstName, lastName);
            ResponseEntity.ok(usersByName);
        } catch (UserException userException) {
            log.error(ERROR_LOG + userException.getMessage(), userException);
        }

        return null;
    }

    @PostMapping(USERS_REST_SAVE_USER)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if(user != null) {
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        }

        return null;
    }

    @DeleteMapping(USERS_REST_DELETE_USER)
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        if(id != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok().body("User deleted!");
        }

        return ResponseEntity.badRequest().body("Provided empty data");
    }
}
