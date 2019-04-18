package de.jonashackt.springbootvuejs.service;


import de.jonashackt.springbootvuejs.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    User findById(Long id);

    User save(User user);

    User update(User user);

    List<User> findAll();
}
