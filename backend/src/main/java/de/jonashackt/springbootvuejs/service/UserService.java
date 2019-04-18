package de.jonashackt.springbootvuejs.service;


import de.jonashackt.springbootvuejs.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User save(User user);

    User update(User user);

    List<User> findAll();
}
