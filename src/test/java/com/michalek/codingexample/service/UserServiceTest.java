package com.michalek.codingexample.service;

import com.michalek.codingexample.entity.User;
import com.michalek.codingexample.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    private static final Long ID = 1L;
    private static final String FIRSTNAME = "Frank";
    private static final String LASTNAME = "Sinatra";
    private static final String EMAIL = "frank@test.com";
    private static final String PASSWORD = "frankPassword";

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private final User user = createUser();

    @BeforeEach
    public void init() {
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(List.of(user)));
        when(userRepository.findByFirstNameAndLastName(any(), any())).thenReturn(Optional.of(List.of(user)));
        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userRepository.save(any())).thenReturn(user);
        doNothing().when(userRepository).delete(any());
    }

    @Test
    public void GIVEN_nothing_WHEN_find_all_users_THEN_users_found() {
        //GIVEN
        //WHEN
        List<User> users = userService.getUsers();

        //THEN
        assertThat(users).isNotNull();
        assertThat(users.get(0).getId()).isEqualTo(ID);
    }

    @Test
    public void GIVEN_user_id_WHEN_find_user_THEN_user_found() {
        //GIVEN
        //WHEN
        User user = userService.getUserById(ID);

        //THEN
        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(FIRSTNAME);
    }

    @Test
    public void GIVEN_email_WHEN_find_user_THEN_user_found() {
        //GIVEN

        //WHEN
        List<User> users = userService.getUserByEmail(EMAIL);

        //THEN
        assertThat(users).isNotNull();
        assertThat(users.get(0).getId()).isEqualTo(ID);
    }

    @Test
    public void GIVEN_first_and_last_name_WHEN_find_users_THEN_users_found() {
        //GIVEN
        //WHEN
        List<User> users = userService.getUserByName(FIRSTNAME, LASTNAME);

        //THEN
        assertThat(users).isNotNull();
    }

    @Test
    public void GIVEN_data_WHEN_create_user_THEN_user_created() {
        //GIVEN
        User user1 = createUser();

        //WHEN
        User user2 = userService.saveUser(user1);

        //THEN
        assertThat(user2).isNotNull();
        assertThat(user2.getEmail()).isEqualTo(EMAIL);
    }

    @Test
    public void GIVEN_id_WHEN_delete_id_THEN_user_deleted() {
        //GIVEN
        //WHEN
        userService.deleteUser(ID);

        //THEN
        verify(userRepository, times(1)).delete(any());
    }



    private static User createUser() {
        User user = new User();

        user.setFirstName(FIRSTNAME);
        user.setLastName(LASTNAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setId(ID);

        return user;
    }
}