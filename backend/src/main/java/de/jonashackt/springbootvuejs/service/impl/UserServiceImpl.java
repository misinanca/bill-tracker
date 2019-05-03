package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.entity.User;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).get();

        return ofNullable(user)
                .orElse(null);
    }

    @Override
    public User save(User user) {
        Optional<User> optionalUser;

        optionalUser = userRepository.findUserByUsername(user.getUsername());

        User user1 = optionalUser.isPresent() ? null : userRepository.save(user);

        return ofNullable(user1)
                .orElseThrow(() -> new EntityExistsException("User already exist: " + user.getUsername()));
    }

    @Override
    public User update(User user) {
        User user1 = userRepository.save(user);

        return ofNullable(user1)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with ID: " + user.getId()));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
