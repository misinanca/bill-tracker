package de.jonashackt.springbootvuejs.controller.impl;

import de.jonashackt.springbootvuejs.controller.UserRestApi;
import de.jonashackt.springbootvuejs.controller.dtos.UserDTO;
import de.jonashackt.springbootvuejs.entity.Role;
import de.jonashackt.springbootvuejs.entity.User;
import de.jonashackt.springbootvuejs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController implements UserRestApi {

    private final UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserRestController(final UserService userService) {
        this.userService = userService;
    }

//    @PreAuthorize("hasAuthority('USER')")
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//    @Override
//    public User findById(@PathVariable("id") Long id) {
//        return userService.findById(id);
//    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    @Override
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/public/user/register", method = RequestMethod.POST)
    @Override
    public @ResponseBody User register(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username);
        user.setAddress(userDTO.address);
        user.setEmail(userDTO.email);
        user.setFirstName(userDTO.firstName);
        user.setLastName(userDTO.lastName);
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPasswordHash(encryptedPassword);
        user.setRole(Role.USER);

        return userService.save(user);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/users/get", method = RequestMethod.GET)
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
