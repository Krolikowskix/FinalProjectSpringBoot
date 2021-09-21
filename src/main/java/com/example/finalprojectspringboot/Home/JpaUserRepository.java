package com.example.finalprojectspringboot.Home;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaUserRepository implements UserService {

    private final UserRepository userRepository;

    public JpaUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> userGetByLogin(String login, String password) {
        return userRepository.findAllByLoginAndPassword(login, password);
    }
    @Override
    public List<User> userGetByEmail(String email, String password) {
        return userRepository.findAllByEmailAndPassword(email, password);
    }

}