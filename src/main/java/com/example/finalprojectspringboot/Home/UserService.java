package com.example.finalprojectspringboot.Home;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    Optional<User> get(Long id);

    void add(User user);

    void delete(Long id);

    void update(User user);

    List<User> userGetByLogin(String login, String password);

    List<User> userGetByEmail(String email, String password);
}
