package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService {

    User findByEmail(String email);

    User findByUsername(String username);

    List<User> getAllUsers();

    void save(User user);

    void removeUserById(Long id);

    User getUserById(Long id);

    void updateUser(User user, Long id);
}